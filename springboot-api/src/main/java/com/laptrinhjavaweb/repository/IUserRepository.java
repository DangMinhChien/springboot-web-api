package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserRepository 
//extends JpaRepository<UserEntity> 
extends JpaRepository<UserEntity, Long>{
//	List<UserEntity> findAllUser(String role);
//	List<UserEntity> findUsersAssignmentByBuildingId(Long buildingId , String role);
	
	List<UserEntity> findByUsersBuilding_IdAndRole_Id(Long buildingId, String role);
	
	List<UserEntity> findByUsersCustomer_IdAndRole_Id(Long customerId, String role);
	
	List<UserEntity> findByRoles_Code(String role);
	
	Boolean exitstByIdAndUsersBuilding(Long staffId , Long buildingId);
	
	Boolean exitstByIdAndUsersCustomer(Long staffId , Long customerId);
}
