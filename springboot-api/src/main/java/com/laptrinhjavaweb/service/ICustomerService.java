package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.input.CustomerDetailInput;
import com.laptrinhjavaweb.dto.output.CustomerDetailOutput;

public interface ICustomerService {
	CustomerDetailOutput getCustomerDetail(CustomerDetailInput customerDetailInput);
}
