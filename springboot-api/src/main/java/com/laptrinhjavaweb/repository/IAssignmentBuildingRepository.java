package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;

public interface IAssignmentBuildingRepository {
	Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);

	Boolean isAssignmentbuilding(Long buildingId , Long staffId);
}
