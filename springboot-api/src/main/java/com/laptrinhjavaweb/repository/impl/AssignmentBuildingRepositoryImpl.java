package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;

public class AssignmentBuildingRepositoryImpl extends SimpleJpaRepository<AssignmentBuildingEntity> implements IAssignmentBuildingRepository {

	@Override
	public Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	try {
		conn = EntityManagerFactory.getInstance().getConnection();
		List<Long> oldUsers = getOldUsers(conn, assignmentBuildingInput.getBuildingId());
		List<Long> newUsers = new ArrayList<>();
		Long[] ids = assignmentBuildingInput.getStaffIds();
		for (int i = 0; i < ids.length; i++) {
			newUsers.add(ids[i]);
		}
		List<Long> checkedUsers = getIsCheckedUsers(oldUsers,newUsers);
		List<Long> uncheckedUsers =getIsUncheckedUsers(oldUsers,newUsers);
		if (!uncheckedUsers.isEmpty()) {
			String sqlDelete = buildingSqlDelete(uncheckedUsers,assignmentBuildingInput.getBuildingId());
			stmt = conn.prepareStatement(sqlDelete);
			stmt.executeUpdate();
		}if (!checkedUsers.isEmpty()) {
			String sqlInsert = buildingInsert(checkedUsers,assignmentBuildingInput.getBuildingId());
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

	private String buildingInsert(List<Long> uncheckedUsers, Long buildingId) {
		StringBuilder values = new StringBuilder("");
		for (Long item : uncheckedUsers) {
			values.append(" DELETE FROM assignmentbuilding WHERE staffid="+item +" and buildingid ="+buildingId+" ;");
		}
		return values.toString();
	}

	private String buildingSqlDelete(List<Long> checkedUsers, Long buildingId) {
		StringBuilder values = new StringBuilder("");
		for (Long item : checkedUsers) {
			values.append(" INSERT INTO assignmentbuilding(staffid,buildingid) VALUES("+item+","+buildingId+");\\n");
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

	private List<Long> getOldUsers(Connection conn, Long buildingId)throws Exception {
		String sql ="SELECT staffid FROM assignmentbuilding where buildingid ="+buildingId;
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
	public Boolean isAssignmentbuilding(Long buildingId ,Long staffId) {
		String sql = "SELECT * FROM assignmentbuilding where buildingid = " + buildingId + "and staffid= = " + staffId + "";
		List<AssignmentBuildingEntity> result= this.findAll(sql);
		if (result.isEmpty()) {
			return false;
		}else {
			return true;
		}
		
	}
}
