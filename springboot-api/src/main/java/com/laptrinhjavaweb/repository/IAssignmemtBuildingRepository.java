package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;

public interface IAssignmemtBuildingRepository  extends JpaRepository<AssignmentBuildingEntity>{
List<AssignmentBuildingEntity> findByBuildingId(Long buildingId);
}
