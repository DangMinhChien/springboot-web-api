package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.input.UserInput;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.UserServiceImpl;

@RestController
public class UserAPI {
	private IUserService userService = new UserServiceImpl();
	@PostMapping("/users/manager-building")
	public List<UserOutput> getUser(@RequestBody UserInput userInput) {		
		return userService.findAllUser(userInput.getBuildingId(), userInput.getRole());
	}
	
}
