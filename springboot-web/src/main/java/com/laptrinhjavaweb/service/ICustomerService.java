package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;

public interface ICustomerService {
	CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput);
	CustomerDTO save(CustomerDTO customerDTO);
	CustomerDTO update(CustomerDTO customerDTO);
	List<CustomerDTO> findAll();
	void delete(long[] ids);
}
