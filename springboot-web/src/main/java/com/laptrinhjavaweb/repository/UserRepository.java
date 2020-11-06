package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findOneByUserNameAndStatus(String name, int status);

	List<UserEntity> findByStatusAndRoles_Code(Integer status, String roleCode);

	List<UserEntity> findByUsersBuilding_IdAndRole_Id(Long buildingId, String role);

	List<UserEntity> findByUsersCustomer_IdAndRole_Id(Long customerId, String role);

	List<UserEntity> findByRoles_Code(String role);

	Boolean exitstByIdAndUsersBuilding(Long staffId, Long buildingId);

	Boolean exitstByIdAndUsersCustomer(Long staffId, Long customerId);

}
