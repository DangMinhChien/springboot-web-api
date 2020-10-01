package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.output.UserOutput;

public interface IUserService {
	List<UserOutput> findAllUserByBuilding(Long buildingId , String role);
	
	List<UserOutput> findAllUserByCustomer(Long customerId , String role);
}
