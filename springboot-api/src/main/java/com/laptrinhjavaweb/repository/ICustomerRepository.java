package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;

public interface ICustomerRepository 
//extends JpaRepository<CustomerEntity>
extends JpaRepository<CustomerEntity, Long> , CustomerRepositoryCustom{
	@Query(value = "DELTE FROM assignmentcustomer WHERE customerid = :id",nativeQuery = true)
	int deleteAssignmentCustomerByIdNative(@Param("id") Long id);
	
	@Query(value = "DELTE FROM assignmentcustomer WHERE customerid = :customerId and staffid = :staffId ",nativeQuery = true)
	int deleteAssignmentByCustomerIdAndStaffIdNative(@Param("customerId") Long customerId,@Param("staffid") Long staffId); 
	
	@Query(value = "INSERT INTO assignmentcustomer(customerId,staffid) VALUES(:item,:customerId)",nativeQuery = true)
	int insertAssignment(@Param("customerId") Long customerId,@Param("staffid") Long staffId); 
}
