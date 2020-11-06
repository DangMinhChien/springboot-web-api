package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerEntity> getCustomers(CustomerSearchBuilder customerSearchBuilder) {
		StringBuilder sql = new StringBuilder("SELECT * FROM customer c ");
		// Câu inner Join
		if (customerSearchBuilder.getStaffId() != null) {
			sql.append("inner join assignmentcustomer a on a.customerid = c.id ");
		}
		sql.append("where 1=1");
		sql = customerSearchBuilderCommon(customerSearchBuilder, sql);
		if (customerSearchBuilder.getStaffId() != null) {
			sql.append("and a.staffid = " + customerSearchBuilder.getStaffId() + "");
		}
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
	return query.getResultList();
	}
	
	// Xử lý buildingSearchBuilder
	private StringBuilder customerSearchBuilderCommon(CustomerSearchBuilder customerSearchBuilder, StringBuilder sql) {
		try {
			Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().equals("staffId")) {
					field.setAccessible(true);
					String fieldType = field.getType().getName();
					if (fieldType.equals("java.lang.String")) {
						if (field.get(customerSearchBuilder) != null) {
							sql.append(" and c." + field.getName().toLowerCase() + " like '%"
									+ field.get(customerSearchBuilder) + "%'");
						}
					}
				}
			}
			return sql;
		} catch (IllegalAccessException e) {
			return new StringBuilder("");
		}

	}
}
