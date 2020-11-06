package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

//import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingReponsitoryCustom;
public interface IBuildingRepository 
extends JpaRepository<BuildingEntity, Long> , BuildingReponsitoryCustom {
	@Query(value = "DELTE FROM assignmentbuilding WHERE buildingid = :id",nativeQuery = true)
	int deleteAssignmentByIdNative(@Param("id") Long id); 
	
	@Query(value = "DELTE FROM assignmentbuilding WHERE buildingid = :buildingId and staffid = :staffId ",nativeQuery = true)
	int deleteAssignmentByBuildingIdAndStaffIdNative(@Param("buildingId") Long buildingId,@Param("staffid") Long staffId); 
	
	@Query(value = "INSERT INTO assignmentbuilding(buildingid,staffid) VALUES(:item,:buildingId)",nativeQuery = true)
	int insertAssignment(@Param("buildingId") Long buildingId,@Param("staffid") Long staffId); 
	
}
