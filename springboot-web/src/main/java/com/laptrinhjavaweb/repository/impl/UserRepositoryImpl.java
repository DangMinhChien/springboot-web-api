package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.StaffEntity;
import com.laptrinhjavaweb.repository.IUserRepository;

public class UserRepositoryImpl extends SimpleJpaRepository<StaffEntity> implements IUserRepository {

	@Override
	public List<StaffEntity> findUsersAssignmentByBuildingId(Long buildingId, String role) {
		String sql = "SELECT * FROM user u INNER JOIN assignmentbuilding a on u.id=a.staffid INNER JOIN user_role ur on u.id = ur.userid INNER JOIN role r on ur.roleid = r.id where buildingid ="
				+ buildingId + " and code = " + role + "";
		return this.findAll(sql);
	}

	@Override
	public List<StaffEntity> findAllUser(String role) {
		String sql = "SELECT * FROM user u  INNER JOIN user_role ur on u.id = ur.userid INNER JOIN role r on ur.roleid = r.id where code = "
				+ role + "";
		return this.findAll(sql);
	}



}
