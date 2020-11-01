package com.laptrinhjavaweb.repository.custom;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface BuildingReponsitoryCustom {
	List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
}
