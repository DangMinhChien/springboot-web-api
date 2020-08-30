package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;
import com.laptrinhjavaweb.repository.JpaRepository;
import com.laptrinhjavaweb.util.ResultSetMapper;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	private Class<T> zClass;

	public SimpleJpaRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType p = (ParameterizedType) t;
		zClass = (Class<T>) p.getActualTypeArguments()[0];
	}

	// Save
	@Override
	public Long save(Object object) {
		String sql = builSQLInsert();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = EntityManagerFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			int index = 1;
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				stmt.setObject(index, field.get(object));
				index++;
			}
			stmt.executeUpdate();
			conn.commit();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getLong(1);
			}
		} catch (SQLException | IllegalAccessException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			return null;

		}
	}

	// buil câu INSERT
	private String builSQLInsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				fields.append(column.name());
				params.append("?");
			}
		}
		String sql = "INSERT INTO " + tableName + "(" + fields.toString() + ") VALUES(" + params.toString() + ")";
		return sql;
	}

	// FindAll
	@Override
	public List<T> findAll() {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String tableName = "";
			conn = EntityManagerFactory.getInstance().getConnection();
			stmt = conn.createStatement();
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "SELECT * FROM " + tableName + "where 1=1";
			rs = stmt.executeQuery(sql);
			return resultSetMapper.mapRow(rs, this.zClass);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}		
				
			} catch (SQLException se) {
			}  
		} 
		return null;
	}

	/*
	 * findById
	 */
	@Override
	public T findById(Long id) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String tableName = "";
			conn = EntityManagerFactory.getInstance().getConnection();
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			String sql = "SELECT * FROM " + tableName + "where id = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			List<T> result = resultSetMapper.mapRow(rs, this.zClass);
			return result!=null ? result.get(0) :null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}		
				
			} catch (SQLException se) {
			}  
		} 
		return null;
	}

	@Override
	public int update(Object object) {
		String sql = builSQLUpdate();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			conn = EntityManagerFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			int index = 1;
			Object id = null;
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				if (!field.getName().equals("id")) {
					stmt.setObject(index, field.get(object));
					index++;
				} else {
					id=field.get(object);
				}

			}
			stmt.setObject(index, id);
			result = stmt.executeUpdate();
			conn.commit();
			return result ;
		} catch (SQLException | IllegalAccessException se) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result ;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	private String builSQLUpdate() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder set = new StringBuilder("");
		for (Field field : zClass.getDeclaredFields()) {
			if (set.length() > 1) {
				set.append(",");
			}
			if (!field.getName().equals("id") &&field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
				set.append(column.name() + "= ?");
			}
		}
		String sql = "UPDATE " + tableName + " SET " + set.toString() + " WHERE  id =?";
		return sql;
	}

	@Override
	public int delete(Long id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			String sql = builSQLDelete();
			conn = EntityManagerFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			result = stmt.executeUpdate();
			conn.commit();
			return result ;
		} catch (SQLException se) {		
			try {
				conn.rollback();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}

	private String builSQLDelete() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "DELETE FROM " + tableName + " WHERE id = ?" ;
		return sql;
	}

	@Override
	public List<T> findAll(String sql) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String tableName = "";
			conn = EntityManagerFactory.getInstance().getConnection();
			stmt = conn.createStatement();
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}
			rs = stmt.executeQuery(sql);
			return resultSetMapper.mapRow(rs, this.zClass);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}		
				
			} catch (SQLException se) {
			}  
		} 
		return null;
	}

}
