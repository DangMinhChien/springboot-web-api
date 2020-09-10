package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;

public interface IAssignmentBuildingRepository {
Boolean assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);
List<AssignmentBuildingEntity> findByBuildingIdAndStaffId(Long buildingId , Long staffId);
}
