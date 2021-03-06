package com.laptrinhjavaweb.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotations.Column;

public class ResultSetMapper<T> {
public List<T> mapRow(ResultSet rs , Class<T>zClass){
	List<T> result = new ArrayList<>();
	try {
		Field[] fields = zClass.getDeclaredFields();
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		while(rs.next()) {
		T object = zClass.newInstance();
		for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
			String columnName = resultSetMetaData.getColumnName(i+1);
			Object columnValue = rs.getObject(columnName);
			for (Field field : fields) {
				Column column = field.getAnnotation(Column.class);
				if (column.name().equals(columnName) && columnValue!=null) {
					BeanUtils.setProperty(object, field.getName(), columnValue);
					break;
				}
			}
		}
		result.add(object);
		}
	} catch (Exception e) {
	}
	return result;
}
}
