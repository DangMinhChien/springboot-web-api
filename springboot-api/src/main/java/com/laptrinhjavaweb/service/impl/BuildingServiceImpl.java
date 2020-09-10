package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.IRentAreaRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.RentAreaRepositoryImpl;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingServiceImpl implements IBuildingService {

	private IBuildingRepository buildingRepository = new BuildingRepositoryImpl();
	private IRentAreaRepository rentAreaRepository = new RentAreaRepositoryImpl();
	private BuildingConverter buildingConverter = new BuildingConverter();

	@Override
	public List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
			results.add(buildingDTO);
		}
		return results;
	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
//		Long buildingId =  buildingRepository.save(buildingDTO);
//		String rentArea = buildingDTO.getRentArea();
//		String [] valueRentArea = rentArea.split(",");
//		//Insert RentArea
//		for (String value : valueRentArea) {
//			RentAreaDTO rentAreaDTO = new RentAreaDTO();
//			rentAreaDTO.setValue(Integer.parseInt(value));
//			rentAreaDTO.setBuildingId(buildingId);
//			rentAreaRepository.save(rentAreaDTO);
//		}
//		return buildingRepository.findById(buildingId);
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		Long id = buildingRepository.save(buildingEntity);
		if (buildingDTO.getRentArea() != null && !buildingDTO.getRentArea().isEmpty()) {
			String rentArea = buildingDTO.getRentArea();
			String[] valueRentArea = rentArea.split(",");
			// Insert RentArea
			for (String value : valueRentArea) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(Integer.parseInt(value));
				rentAreaEntity.setBuildingId(id);
				rentAreaRepository.save(rentAreaEntity);
			}
		}
		BuildingDTO dto = buildingConverter.convertToDto(buildingRepository.findById(id));
		return dto;
	}

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
			results.add(buildingDTO);
		}
		return results;
	}

	@Override
	public Boolean update(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		int result = buildingRepository.update(buildingEntity);
		if (buildingDTO.getRentArea() != null && !buildingDTO.getRentArea().isEmpty()) {
			String rentArea = buildingDTO.getRentArea();
			String[] valueRentArea = rentArea.split(",");
			// Insert RentArea
			for (String value : valueRentArea) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(Integer.parseInt(value));
				rentAreaEntity.setBuildingId(buildingDTO.getId());
				rentAreaRepository.update(rentAreaEntity);
			}
		}
		return result == 1 ? true : false;
	}

	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			String sql = "SELECT * FROM rentarea where buildingid = " + item + "";
			List<RentAreaEntity> result = rentAreaRepository.findAll(sql);
			for (RentAreaEntity rentAreaEntity : result) {
				rentAreaRepository.delete(rentAreaEntity.getId());
			}
			buildingRepository.delete(item);
		}
	}
}
