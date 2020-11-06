package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IUserRepository;
import com.laptrinhjavaweb.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
//	@Autowired
//	private AssignmentBuildingRepositoryImpl  assignmentBuildingRepository ;
//	@Autowired
//	private AssignmentCustomerRepositoryImpl  assignmentCustomerRepository ;
	@Autowired
	private IUserRepository  userRepository ;

	@Autowired
	private UserConverter  userConverter ;
	
//	@Autowired
//	private TransactionConverter  transactionConvert ;
//	private IAssignmentBuildingRepository assignmentBuildingRepository = new AssignmentBuildingRepositoryImpl();
// 	private IAssignmentCustomerRepository assignmentCustomerRepository = new AssignmentCustomerRepositoryImpl();
//	private IUserRepository userRepository = new UserRepositoryImpl();
//	private UserConverter userConverter = new UserConverter();

	@Override
	public List<UserOutput> findAllUserByBuilding(Long buildingId, String role) {
//		List<UserOutput> result = new ArrayList<>();
//		List<UserEntity> userAssignmentBuildings = userRepository.findUsersAssignmentByBuildingId(buildingId, role);
		List<UserEntity> staffs = userRepository.findByRoles_Code(role);
//		for (int i = 0; i < staffs.size(); i++) {
//			UserOutput output = userConverter.convertToDto(staffs.get(i));
//			for (UserEntity userEntity : userAssignmentBuildings) {
//				if (userEntity.getId()== output.getId()) {
//					output.setChecked("checked");
//					break;
//				}
//			}
//			result.add(output);
//		}
//		for (UserEntity userEntity : staffs) {
//			UserOutput output = userConverter.convertToDto(userEntity);
//			if (assignmentBuildingRepository.isAssignmentbuilding(buildingId, output.getId()) == true) {				
//				output.setChecked("checked");
//			}
//			result.add(output);
//		}	
		List<UserOutput> result = staffs.stream().map(item -> {
			UserOutput output = userConverter.convertToDto(item);
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
			UserOutput output = userConverter.convertToDto(item);
			if (userRepository.exitstByIdAndUsersCustomer(output.getId(), customerId) == true) {
				output.setChecked("checked");
			}
			return output;
		}).collect(Collectors.toList());
		return result;
	}

}
