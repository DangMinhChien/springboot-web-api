package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.emun.TypeBuilding;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingReponsitoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService{
	@Autowired
	private BuildingReponsitoryCustom  buildingRepository ;
	@Autowired
	private BuildingConverter buildingConverter ;
	@Override
	public Map<String, String> getBuilding() {
		Map<String, String> results = new HashMap<>();
		for (TypeBuilding type : TypeBuilding.values()) {
				results.put(type.name(), type.getName());
	        }
		return results;
	}

	@Override
	public List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item))
																.collect(Collectors.toList());
		return results;
	}

}
