package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface IRentAreaRepository
//extends JpaRepository<RentAreaEntity> 
extends JpaRepository<RentAreaEntity, Long> {
//	Long save( RentAreaDTO rentAreaDTO);
	int deleteByBuildingEntityId(Long id);
	
	List<RentAreaEntity> findByBuilding_Id(Long Id);
}
