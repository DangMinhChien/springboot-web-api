package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
Map<String, String> getBuilding();
List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
}
