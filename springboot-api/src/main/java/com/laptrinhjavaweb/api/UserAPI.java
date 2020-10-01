package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.input.UserByBuildingInput;
import com.laptrinhjavaweb.dto.input.UserByCustomerInput;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.UserServiceImpl;

@RestController
public class UserAPI {
	private IUserService userService = new UserServiceImpl();
	@PostMapping("/users/manager-building")
	public List<UserOutput> getUserByBuilding(@RequestBody UserByBuildingInput userInput) {		
		return userService.findAllUserByBuilding(userInput.getBuildingId(), userInput.getRole());
	}
	
	@PostMapping("/users/manager-customer")
	public List<UserOutput> getUserByCustomer(@RequestBody UserByCustomerInput userInput) {		
		return userService.findAllUserByCustomer(userInput.getCustomerId(), userInput.getRole());
	}
}
