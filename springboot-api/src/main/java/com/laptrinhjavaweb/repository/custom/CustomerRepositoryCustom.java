package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.buider.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;

public interface CustomerRepositoryCustom {
	List<CustomerEntity> getCustomers(CustomerSearchBuilder customerSearchBuilder);
}
