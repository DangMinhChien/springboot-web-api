package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity> {
	List<UserEntity> findAllUser(String role);
	List<UserEntity> findUsersAssignmentByBuildingId(Long buildingId , String role);
}
