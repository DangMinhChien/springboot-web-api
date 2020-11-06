package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.output.UserOutput;

public interface IUserService {

    UserDTO findOneByUserNameAndStatus(String name, int status);

	Map<Long, String> getStaffMaps();

	List<UserOutput> findAllUserByBuilding(Long buildingId, String role);

	List<UserOutput> findAllUserByCustomer(Long customerId, String role);

}