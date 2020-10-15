package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.impl.AssignmentBuildingRepositoryImpl;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
@Service
public class AssignmentBuildingServiceImpl implements IAssignmentBuildingService {
	@Autowired
	private AssignmentBuildingRepositoryImpl assignmentBuiding ;
//	IAssignmentBuildingRepository assignmentBuiding = new AssignmentBuildingRepositoryImpl();

	@Override
	public Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		return assignmentBuiding.assignmentBuilding(assignmentBuildingInput);
	}

}
