package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingReponsitoryCustom;
public interface IBuildingRepository 
//extends JpaRepository<BuildingEntity>
extends JpaRepository<BuildingEntity, Long> , BuildingReponsitoryCustom {
	@Query(value = "DELTE FROM assignmentbuilding WHERE buildingId = :id",nativeQuery = true)
	int deleteAssignmentByIdNative(@Param("id") Long id); 
//	Long save(BuildingDTO buildingDTO);
//	Long saveWithTransaction(BuildingDTO buildingDTO);
//	BuildingDTO findById(Long buildingId);
}
