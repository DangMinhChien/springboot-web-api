package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.IRentAreaRepository;

public class RentAreaRepositoryImpl extends SimpleJpaRepository<RentAreaEntity> implements IRentAreaRepository {

	
	// Save RentArea
//	@Override
//	public Long save(RentAreaDTO rentAreaDTO) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			
//			conn = EntityManagerFactory.getInstance().getConnection();
//			conn.setAutoCommit(false);
//			StringBuilder sql = new StringBuilder("INSERT INTO rentarea VALUES ( ?,?)");
//			stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
//			stmt.setInt(1, rentAreaDTO.getValue());
//			stmt.setLong(2, rentAreaDTO.getBuildingId());
//			stmt.executeUpdate();
//			conn.commit();
//			rs = stmt.getGeneratedKeys();
//			if (rs.next()) {
//				return rs.getLong(1);
//			}
//		} catch (SQLException se) {
//			try {
//				conn.rollback();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			// Handle errors for Class.forName
//			e.printStackTrace();
//		}  finally {
//			try {
//				if (conn != null) {
//					conn.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (rs != null) {
//					rs.close();
//				}
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//			return null;
//
//		}
//	}

}
