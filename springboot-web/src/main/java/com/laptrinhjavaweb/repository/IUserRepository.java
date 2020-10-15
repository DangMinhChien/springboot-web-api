package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.StaffEntity;
import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserRepository extends JpaRepository<StaffEntity> {
	List<StaffEntity> findAllUser(String role);
	List<StaffEntity> findUsersAssignmentByBuildingId(Long buildingId , String role);
}
