package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO findOneByUserNameAndStatus(String name, int status) {
		return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
	}

	@Override
	public Map<Long, String> getStaffMaps() {
		Map<Long, String> results = new HashMap<>();
		List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
		for (UserEntity staff : staffs) {
			results.put(staff.getId(), staff.getFullName());
		}
		return results;
	}

	@Override
	public List<UserOutput> findAllUserByBuilding(Long buildingId, String role) {
		List<UserEntity> staffs = userRepository.findByRoles_Code(role);
		List<UserOutput> result = staffs.stream().map(item -> {
			UserOutput output = userConverter.convertToOuput(item);
			if (userRepository.exitstByIdAndUsersBuilding(output.getId(), buildingId) == true) {
				output.setChecked("checked");
			}
			return output;
		}).collect(Collectors.toList());
		return result;
	}

	@Override
	public List<UserOutput> findAllUserByCustomer(Long customerId, String role) {
		List<UserEntity> staffs = userRepository.findByRoles_Code(role);
		List<UserOutput> result = staffs.stream().map(item -> {
			UserOutput output = userConverter.convertToOuput(item);
			if (userRepository.exitstByIdAndUsersCustomer(output.getId(), customerId) == true) {
				output.setChecked("checked");
			}
			return output;
		}).collect(Collectors.toList());
		return result;
	}
}