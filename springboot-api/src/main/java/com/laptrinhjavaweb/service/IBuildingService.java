package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;

public interface IBuildingService {
	List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);

	BuildingDTO save(BuildingDTO buildingDTO);

	BuildingDTO update(BuildingDTO buildingDTO);

	List<BuildingDTO> findAll();

	void delete(long[] ids);

	//AssignmentBuilding
	void assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput);
}
