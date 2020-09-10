package com.laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepositoryImpl extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {
//Tìm kiếm tòa nhà 
	@Override
	public List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
			StringBuilder sql = new StringBuilder("SELECT * FROM building b ");
			// Câu inner Join
			if (buildingSearchBuilder.getStaffId() != null) {
				sql.append("inner join assignmentbuilding a on a.buildingid = b.id ");
			}
			sql.append("where 1=1");
			sql = buildingSearchBuilderCommon(buildingSearchBuilder, sql);
			sql = buildingSearchBuilderSpecial(buildingSearchBuilder, sql);
			if (buildingSearchBuilder.getStaffId() != null) {
				sql.append("and a.staffid = " + buildingSearchBuilder.getStaffId() + "");
			}
			results = this.findAll(sql.toString());
		return results;
	}

	private StringBuilder buildingSearchBuilderSpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		// rentPrice
		if (buildingSearchBuilder.getRentAreaFrom() != null) {
			sql.append("and " + "rentprice >=" + buildingSearchBuilder.getRentAreaFrom() + "");
		}
		if (buildingSearchBuilder.getRentAreaTo() != null) {
			sql.append("and " + "rentprice <=" + buildingSearchBuilder.getRentAreaTo() + "");
		}
		// Tìm loại toàn nhà
		if (buildingSearchBuilder.getTypes() != null) {
			int lengthType = buildingSearchBuilder.getTypes().length;
			sql.append("and ( b.type like '%" + buildingSearchBuilder.getTypes()[0] + "%'");
			for (int i = 1; i < lengthType; i++) {
				if (i >= 1) {
					sql.append("or b.type like '%" + buildingSearchBuilder.getTypes()[i] + "%'");
				}
			}
			sql.append(")");
		}
		// Tìm theo diện tích
		if (buildingSearchBuilder.getRentAreaFrom() != null || buildingSearchBuilder.getRentAreaTo() != null) {
			sql.append(" and EXISTS (SELECT * FROM rentarea r WHERE r.buildingid = b.id");
			if (buildingSearchBuilder.getRentAreaFrom() != null) {
				sql.append(" and r.value >=" + buildingSearchBuilder.getRentAreaFrom() + "");
			} else if (buildingSearchBuilder.getRentAreaTo() != null) {
				sql.append(" and r.value <=" + buildingSearchBuilder.getRentAreaTo() + "");
			}
			sql.append("))");
		}
		return sql;

	}

	// Xử lý buildingSearchBuilder
	private StringBuilder buildingSearchBuilderCommon(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for (Field field : fields) {
				if (!field.getName().equals("staffId") && !field.getName().startsWith("rentArea")
						&& !field.getName().startsWith("rentPrice") && !field.getName().equals("types")) {
					field.setAccessible(true);
					String fieldType = field.getType().getName();
					if (fieldType.equals("java.lang.String")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append(" and b" + field.getName().toLowerCase() + " like '%"
									+ field.get(buildingSearchBuilder) + "%'");
						}
					} else if (fieldType.equals("java.lang.Integer")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append("and b" + field.getName().toLowerCase() + " = '%"
									+ field.get(buildingSearchBuilder) + "%'");
						}
					}
				}
			}
			return sql;
		} catch (IllegalAccessException e) {
			return new StringBuilder("");
		}

	}

	// Câu insert building
//	@Override
//	public Long save(BuildingDTO buildingDTO) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = EntityManagerFactory.getInstance().getConnection();
//			conn.setAutoCommit(false);
//			StringBuilder sql = new StringBuilder("INSERT INTO building VALUES ( ");
//			sql = builSQLsaveBuilding(buildingDTO, sql);
//			stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
//			setValueBuilding(buildingDTO, stmt);
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
//		} finally {
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
//
//	}

//	private void setValueBuilding(BuildingDTO buildingDTO, PreparedStatement stmt) {
//		int n = 1;
//		try {
//			Field[] fields = BuildingDTO.class.getDeclaredFields();
//			for (Field field : fields) {
//				if (!field.getName().equals("id") && !field.getName().equals("types")
//						&& !field.getName().equals("manager") && !field.getName().equals("managerMobile")
//						&& !field.getName().equals("staffUserName") && !field.getName().endsWith("from")
//						&& !field.getName().endsWith("to")) {
//					field.setAccessible(true);
//					String fieldType = field.getType().getName();
//					if (fieldType.equals("java.lang.String")) {
//						if (field.get(buildingDTO) != null) {
//							stmt.setString(n, field.get(buildingDTO).toString());
//							n++;
//						}
//					} else if (fieldType.equals("java.lang.Integer")) {
//						if (field.get(buildingDTO) != null) {
//							stmt.setInt(n, (Integer) field.get(buildingDTO));
//							n++;
//						}
//					} else if (fieldType.equals("java.util.Date")) {
//						if (field.get(buildingDTO) != null) {
//							stmt.setDate(n, (Date) field.get(buildingDTO));
//							n++;
//						}
//					} else if (fieldType.equals("java.lang.Float")) {
//						if (field.get(buildingDTO) != null) {
//							stmt.setFloat(n, (Float) field.get(buildingDTO));
//							n++;
//						}
//					}
//				} else if (field.getName().equals("types")) {
//					if (field.get(buildingDTO) != null) {
//						ArrayList<String> types = buildingDTO.getTypes();
//						String type = types.stream().collect(Collectors.joining(String.valueOf(",")));
//						stmt.setString(n, type);
//						n++;
//					}
//				}
//			}
//		} catch (Exception e) {
//		}
//	}

//	// Xử lý builSQLsaveBuilding
//	private StringBuilder builSQLsaveBuilding(BuildingDTO buildingDTO, StringBuilder sql) {
//		try {
//			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
//			for (Field field : fields) {
//				if (!field.getName().equals("id") && !field.getName().equals("manager")
//						&& !field.getName().equals("managerMobile") && !field.getName().equals("staffUserName")
//						&& !field.getName().endsWith("from") && !field.getName().endsWith("to")) {
//					sql.append(field.getName() + " ,");
//				}
//			}
//			sql.append(" ) values ( ? ");
//			for (Field field : fields) {
//				if (!field.getName().equals("id") && !field.getName().equals("name")
//						&& !field.getName().equals("manager") && !field.getName().equals("managerMobile")
//						&& !field.getName().equals("staffUserName") && !field.getName().endsWith("from")
//						&& !field.getName().endsWith("to")) {
//					sql.append(" , ?  ");
//				}
//				sql.append(" ) ");
//			}
//			return sql;
//		} catch (Exception e) {
//			return new StringBuilder("");
//		}
//
//	}

	// Tìm theo id tòa nhà
//	@Override
//	public BuildingDTO findById(Long buildingId) {
//		BuildingDTO buildingDTO = new BuildingDTO();
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = EntityManagerFactory.getInstance().getConnection();
//			StringBuilder sql = new StringBuilder("SELECT * FROM building  where id = ? ");
//			stmt = conn.prepareStatement(sql.toString());
//			stmt.setLong(1, buildingId);
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				try {
//					Field[] fields = BuildingDTO.class.getDeclaredFields();
//					for (Field field : fields) {
//						if (!field.getName().equals("types") && !field.getName().equals("manager")
//								&& !field.getName().equals("managerMobile") && !field.getName().equals("staffUserName")
//								&& !field.getName().endsWith("from") && !field.getName().endsWith("to")) {
//							field.setAccessible(true);
//							String fieldType = field.getType().getName();
//							if (fieldType.equals("java.lang.String")) {
//								field.set(buildingDTO, rs.getString(field.toString().toLowerCase()));
//							} else if (fieldType.equals("java.lang.Integer")) {
//								field.set(buildingDTO, rs.getInt(field.toString().toLowerCase()));
//							} else if (fieldType.equals("java.lang.Float")) {
//								field.set(buildingDTO, rs.getFloat(field.toString().toLowerCase()));
//							} else if (fieldType.equals("java.util.Date")) {
//								field.set(buildingDTO, rs.getDate(field.toString().toLowerCase()));
//							}
//						} // rentPrice
//						else if (field.getName().equals("types")) {
//							String types = rs.getString(field.toString().toLowerCase());
//							List<String> listType = Arrays.stream(types.split(",")).collect(Collectors.toList());
//							field.set(buildingDTO, listType);
//						}
//
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (SQLException se) {
//			// Handle errors for JDBC
//			se.printStackTrace();
//		} catch (Exception e) {
//			// Handle errors for Class.forName
//			e.printStackTrace();
//		} finally {
//			// finally block used to close resources
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//			} // do nothing
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException se) {
//			} // end finally try
//		} // end try
//		return buildingDTO;
//	}

	// Save tòa nhà
	@Override
	public Long saveWithTransaction(BuildingDTO buildingDTO) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = EntityManagerFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			String sqlBuilding = "INSERT INTO building(name , numberofbasement) VALUES ( ?,?)";
			stmt = conn.prepareStatement(sqlBuilding.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, buildingDTO.getName());
			stmt.setInt(2, buildingDTO.getNumberOfBasement());
			stmt.executeUpdate();
			Long buildingId = null;
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				buildingId = rs.getLong(1);
			}
			StringBuilder sqlRentArea = new StringBuilder("INSERT INTO rentarea VALUES ( ?,?)");
			stmt = conn.prepareStatement(sqlRentArea.toString());
			// Insert RentArea
			for (String value : buildingDTO.getRentAreas()) {
				stmt.setInt(1, Integer.parseInt(value));
				stmt.setLong(2, buildingId);
				stmt.executeUpdate();
			}
			conn.commit();
			return buildingId;
		} catch (SQLException se) {
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

}
