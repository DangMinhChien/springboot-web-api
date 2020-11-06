package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.AssignmentCustomerInput;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;

public interface ICustomerService {
	CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput);

	CustomerDTO save(CustomerDTO customerDTO);

	CustomerDTO update(CustomerDTO customerDTO);

	void delete(long[] ids);

	List<CustomerDTO> getCustomers(CustomerSearchBuilder customerSearchBuilder);

	// AssignmentCustomer
	void assignmentCustomer(AssignmentCustomerInput assignmentCustomerInput);
}
