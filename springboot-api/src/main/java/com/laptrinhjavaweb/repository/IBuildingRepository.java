package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity>{
	List<BuildingEntity> getBuildings(BuildingSearchBuilder buildingSearchBuilder);
	
//	Long save(BuildingDTO buildingDTO);
	Long saveWithTransaction(BuildingDTO buildingDTO);
//	BuildingDTO findById(Long buildingId);
}
