package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.repository.IAssignmentCustomerRepository;
import com.laptrinhjavaweb.repository.impl.AssignmentCustomerRepositoryImpl;
import com.laptrinhjavaweb.service.IAssignmentCustomerService;

public class AssignmentCustomerServiceImpl implements IAssignmentCustomerService{
	IAssignmentCustomerRepository assignmentCustomer = new AssignmentCustomerRepositoryImpl();
	@Override
	public Boolean assignmentCustomer(AssignmentCustomerInput assignmentCustomerInput) {
		return assignmentCustomer.assignmentCustomer(assignmentCustomerInput);
	}

}
