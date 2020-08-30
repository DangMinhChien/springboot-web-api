package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.repository.IAssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.impl.AssignmentBuildingRepositoryImpl;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;

public class AssignmentBuildingServiceImpl implements IAssignmentBuildingService {
	IAssignmentBuildingRepository assignmentBuiding = new AssignmentBuildingRepositoryImpl();

	@Override
	public Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		return assignmentBuiding.assignmentBuilding(assignmentBuildingInput);
	}

}
