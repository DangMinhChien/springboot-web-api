package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserRepository 
//extends JpaRepository<UserEntity> 
extends JpaRepository<UserEntity, Long>{
//	List<UserEntity> findAllUser(String role);
//	List<UserEntity> findUsersAssignmentByBuildingId(Long buildingId , String role);
}
