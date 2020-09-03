package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.repository.impl.UserRepositoryImpl;
import com.laptrinhjavaweb.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserRepository userRepository= new UserRepositoryImpl();
	private UserConverter userConverter = new UserConverter();
	@Override
	public List<UserOutput> findAllUser(Long buildingId, String role) {
		List<UserOutput> result = new ArrayList<>();
		List<UserEntity> userAssignmentBuildings = userRepository.findUsersAssignmentByBuildingId(buildingId, role);
		List<UserEntity> staffs = userRepository.findAllUser();
		for (int i = 0; i < staffs.size(); i++) {
			UserOutput output = userConverter.convertToDto(staffs.get(i));
			for (UserEntity userEntity : userAssignmentBuildings) {
				if (userEntity.getId()== output.getId()) {
					output.setChecked("checked");
					break;
				}
			}
			result.add(output);
		}
		return result;
	}

}