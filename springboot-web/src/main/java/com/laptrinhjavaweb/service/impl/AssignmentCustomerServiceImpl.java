package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.repository.impl.AssignmentCustomerRepositoryImpl;
import com.laptrinhjavaweb.service.IAssignmentCustomerService;
@Service
public class AssignmentCustomerServiceImpl implements IAssignmentCustomerService{
	@Autowired
	private AssignmentCustomerRepositoryImpl  assignmentCustomer ;
//	IAssignmentCustomerRepository assignmentCustomer = new AssignmentCustomerRepositoryImpl();
	@Override
	public Boolean assignmentCustomer(AssignmentCustomerInput assignmentCustomerInput) {
		return assignmentCustomer.assignmentCustomer(assignmentCustomerInput);
	}

}
