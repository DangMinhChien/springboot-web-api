package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepositoryImpl;
import com.laptrinhjavaweb.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserRepository userRepository= new UserRepositoryImpl();
	private UserConverter userConverter = new UserConverter();
	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> userEntities = userRepository.findAll();
		for (UserEntity userEntity : userEntities) {
			UserDTO userDTO = userConverter.convertToDto(userEntity);
			results.add(userDTO);
		}
		return results;
	}

}
