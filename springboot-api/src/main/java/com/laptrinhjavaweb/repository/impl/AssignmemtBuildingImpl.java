package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.IAssignmemtBuildingRepository;

public class AssignmemtBuildingImpl extends SimpleJpaRepository<AssignmentBuildingEntity>
		implements IAssignmemtBuildingRepository {
	@Override
	public List<AssignmentBuildingEntity> findByBuildingId(Long buildingId) {
		List<AssignmentBuildingEntity> results = new ArrayList<AssignmentBuildingEntity>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {		
			conn = EntityManagerFactory.getInstance().getConnection();
			StringBuilder sql = new StringBuilder("SELECT * FROM assignmentbuilding  where buildingid = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setLong(1, buildingId);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
				Long staffId = rs.getLong("staffid");
				assignmentBuildingEntity.setStaffId(staffId);
				results.add(assignmentBuildingEntity);
			}
		} catch (Exception e) {
			
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return results;
	}

}
