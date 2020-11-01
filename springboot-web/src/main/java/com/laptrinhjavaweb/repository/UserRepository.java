package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserNameAndStatus(String name, int status);
    List<UserEntity> findByStatusAndRoles_Code(Integer status , String roleCode);
}
