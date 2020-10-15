package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;

public interface IAssignmentBuildingRepository extends JpaRepository<AssignmentBuildingEntity>{
	Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);

	Boolean isAssignmentbuilding(Long buildingId , Long staffId);
}
