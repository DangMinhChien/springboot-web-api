package com.laptrinhjavaweb.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingReponsitoryCustom;
@Repository
public class BuildingResositoryImpl implements BuildingReponsitoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
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
			Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
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
//			int lengthType = buildingSearchBuilder.getTypes().length;
//			sql.append("and ( b.type like '%" + buildingSearchBuilder.getTypes()[0] + "%'");
//			for (int i = 1; i < lengthType; i++) {
//				if (i >= 1) {
//					sql.append("or b.type like '%" + buildingSearchBuilder.getTypes()[i] + "%'");
//				}
//			}
//			sql.append(")");
			sql.append(" and ( ");
			String sqlType = Arrays.stream(buildingSearchBuilder.getTypes())
							.map(item -> " b.type like '% "+item+"%'")
							.collect(Collectors.joining(" OR "));
			sql.append(sqlType);
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
							sql.append(" and b." + field.getName().toLowerCase() + " like '%"
									+ field.get(buildingSearchBuilder) + "%'");
						}
					} else if (fieldType.equals("java.lang.Integer")) {
						if (field.get(buildingSearchBuilder) != null) {
							sql.append("and b." + field.getName().toLowerCase() + " = '%"
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
}
