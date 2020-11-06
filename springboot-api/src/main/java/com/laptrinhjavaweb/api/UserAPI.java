package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.input.UserByBuildingInput;
import com.laptrinhjavaweb.dto.input.UserByCustomerInput;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.service.IUserService;

@RestController
public class UserAPI {
	@Autowired 
	private IUserService userService ;
	@PostMapping("/users/manager-building")
	public List<UserOutput> getUserByBuilding(@RequestBody UserByBuildingInput userInput) {		
		return userService.findAllUserByBuilding(userInput.getBuildingId(), userInput.getRole());
	}
	
	@PostMapping("/users/manager-customer")
	public List<UserOutput> getUserByCustomer(@RequestBody UserByCustomerInput userInput) {		
		return userService.findAllUserByCustomer(userInput.getCustomerId(), userInput.getRole());
	}
}
