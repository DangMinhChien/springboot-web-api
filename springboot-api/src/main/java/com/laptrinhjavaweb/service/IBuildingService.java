package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
BuildingDTO save(BuildingDTO buildingDTO);
List<BuildingDTO> findAll();
}
