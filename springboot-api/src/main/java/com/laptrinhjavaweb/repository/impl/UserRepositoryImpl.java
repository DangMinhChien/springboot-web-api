package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;

public class UserRepositoryImpl  extends SimpleJpaRepository<UserEntity> implements IUserRepository {

	@Override
	public List<UserEntity> findUsersAssignmentByBuildingId(Long buildingId , String role) {
		String sql ="SELECT * FROM user u INNER JOIN assignmentbuilding a on u.id=a.staffid INNER JOIN user_role ur on u.id = ur.userid INNER JOIN role r on ur.roleid = r.id where buildingid =? and code = ?";
		return this.findAll(sql);
	}
	@Override
	public List<UserEntity> findAllUser() {
		String sql = "SELECT * FROM user u  INNER JOIN user_role ur on u.id = ur.userid INNER JOIN role r on ur.roleid = r.id where and code = ?";		
		return this.findAll(sql);
	}

}
