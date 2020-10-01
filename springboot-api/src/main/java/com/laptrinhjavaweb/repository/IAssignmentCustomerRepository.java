package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;

public interface IAssignmentCustomerRepository {
	Boolean assignmentCustomer(AssignmentCustomerInput assignmentCutomerInput);

	Boolean isAssignmentCustomer(Long customerId , Long staffId);
}
