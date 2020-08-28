package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.UserServiceImpl;

@RestController
public class UserAPI {
	private IUserService userService = new UserServiceImpl();
	@GetMapping("/users")
	public List<UserDTO> getBuildings() {
		return userService.findAll();
	}
}
