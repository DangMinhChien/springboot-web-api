package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.entity.AssignmentCustomerEntity;
import com.laptrinhjavaweb.repository.IAssignmentCustomerRepository;

public class AssignmentCustomerRepositoryImpl extends SimpleJpaRepository<AssignmentCustomerEntity> implements IAssignmentCustomerRepository {
	@Override
	public Boolean assignmentCustomer(AssignmentCustomerInput assignmentCutomerInput) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	try {
		conn = EntityManagerFactory.getInstance().getConnection();
		List<Long> oldUsers = getOldUsers(conn, assignmentCutomerInput.getCustomerId());
		List<Long> newUsers = new ArrayList<>();
		Long[] ids = assignmentCutomerInput.getStaff();
		for (int i = 0; i < ids.length; i++) {
			newUsers.add(ids[i]);
		}
		List<Long> checkedUsers = getIsCheckedUsers(oldUsers,newUsers);
		List<Long> uncheckedUsers =getIsUncheckedUsers(oldUsers,newUsers);
		if (!uncheckedUsers.isEmpty()) {
			String sqlDelete = customerSqlDelete(uncheckedUsers,assignmentCutomerInput.getCustomerId());
			stmt = conn.prepareStatement(sqlDelete);
			stmt.executeUpdate();
		}if (!checkedUsers.isEmpty()) {
			String sqlInsert = customerSqlDelete(checkedUsers,assignmentCutomerInput.getCustomerId());
			stmt = conn.prepareStatement(sqlInsert);
			stmt.executeUpdate();
		}
		conn.commit();
		return true;
	} catch (SQLException se) {
		try {
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  finally {
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
		} catch (Exception se) {
			se.printStackTrace();
		}
		return false;
	}
	}
	private String customerSqlDelete(List<Long> uncheckedUsers, Long customerId) {
		StringBuilder values = new StringBuilder("");
		for (Long item : uncheckedUsers) {
			values.append(" DELETE FROM assignmentcustomer WHERE staffid="+item +" and customerid ="+customerId+" ;");
		}
		return values.toString();
	}

	private String customerSqlInsert(List<Long> checkedUsers, Long customerId) {
		StringBuilder values = new StringBuilder("");
		for (Long item : checkedUsers) {
			values.append(" INSERT INTO assignmentcustomer(staffid,customerid) VALUES("+item+","+customerId+");\\n");
		}
		return values.toString();
	}

	private List<Long> getIsCheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long newobj : newUsers) {
			if (!oldUsers.contains(newobj)) {
				result.add(newobj);
			}
		}
		return result;
	}

	private List<Long> getIsUncheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long oldobj : oldUsers) {
			if (!newUsers.contains(oldobj)) {
				result.add(oldobj);
			}
		}
		return result;
	}

	private List<Long> getOldUsers(Connection conn, Long customerId)throws Exception {
		String sql ="SELECT staffid FROM assignmentcustomer where customerdd ="+customerId;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Long> list = new ArrayList<Long>();
		stmt=conn.prepareStatement(sql);
		rs = stmt.executeQuery();
		while (rs.next()) {
		list.add(rs.getLong("staffid"));
		}
		return list;
	}
	@Override
	public Boolean isAssignmentCustomer(Long customerId, Long staffId) {
		String sql = "SELECT * FROM assignmentcustomer where customerid = " + customerId + "and staffid= = " + staffId + "";
		List<AssignmentCustomerEntity> result= this.findAll(sql);
		if (result.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

}
