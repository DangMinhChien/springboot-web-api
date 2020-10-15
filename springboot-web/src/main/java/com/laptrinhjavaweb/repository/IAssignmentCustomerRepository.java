package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.entity.AssignmentCustomerEntity;

public interface IAssignmentCustomerRepository extends JpaRepository<AssignmentCustomerEntity> {
	Boolean assignmentCustomer(AssignmentCustomerInput assignmentCutomerInput);

	Boolean isAssignmentCustomer(Long customerId , Long staffId);
}
