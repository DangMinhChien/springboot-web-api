package com.laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.impl.AssignmentBuildingRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.repository.impl.RentAreaRepositoryImpl;
import com.laptrinhjavaweb.service.IBuildingService;
@Service
public class BuildingServiceImpl implements IBuildingService {
	@Autowired
	private BuildingRepositoryImpl  buildingRepository ;
	@Autowired
	private RentAreaRepositoryImpl  rentAreaRepository ;
	@Autowired
	private AssignmentBuildingRepositoryImpl  assignmentBuildingRepository ;
	@Autowired
	private BuildingConverter  buildingConverter ;

//	private IBuildingRepository buildingRepository = new BuildingRepositoryImpl();
//	private IRentAreaRepository rentAreaRepository = new RentAreaRepositoryImpl();
//	private BuildingConverter buildingConverter = new BuildingConverter();
//	private IAssignmentBuildingRepository assignmentBuildingRepository= new AssignmentBuildingRepositoryImpl();

	@Override
	public List<BuildingDTO> getBuildings(BuildingSearchBuilder buildingSearchBuilder) {
		/*List<BuildingDTO> results = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
			results.add(buildingDTO);
		}
		return results; */
		List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(buildingSearchBuilder);
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item))
																.collect(Collectors.toList());
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
		String types = buildingDTO.getTypes().stream().map(item -> item).collect(Collectors.joining(" , "));
		buildingEntity.setTypes(types);
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
//		List<BuildingDTO> results = new ArrayList<>();
//		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
//		for (BuildingEntity buildingEntity : buildingEntities) {
//			BuildingDTO buildingDTO = buildingConverter.convertToDto(buildingEntity);
//			results.add(buildingDTO);
//		}
//		return results;
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item))
									.collect(Collectors.toList());
		return results;
	}
	@Transactional
	@Override
	public BuildingDTO update(BuildingDTO buildingDTO) {
		BuildingEntity updatebuilding = buildingConverter.convertToEntity(buildingDTO);
		BuildingEntity oldbuilding = buildingRepository.findById(buildingDTO.getId());
		updatebuilding.setModifiedBy(oldbuilding.getModifiedBy());
		updatebuilding.setModifiedDate(oldbuilding.getModifiedDate());
		String sql = "DELTE FROM rentare WHERE buildingId = "+ buildingDTO.getId()+"";
		rentAreaRepository.delete(sql);
		String rentArea = buildingDTO.getRentArea();
		String[] valueRentArea = rentArea.split(",");
		// Insert RentArea
		for (String value : valueRentArea) {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();
			rentAreaEntity.setValue(Integer.parseInt(value));
			rentAreaEntity.setBuildingId(buildingDTO.getId());
			rentAreaRepository.save(rentAreaEntity);
		}
		String types = buildingDTO.getTypes().stream().map(item -> item).collect(Collectors.joining(" , "));
		updatebuilding.setTypes(types);
		buildingRepository.update(updatebuilding);
		return buildingDTO;
	}
	@Transactional
	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			String sqlRentArea = "DELTE FROM rentare WHERE buildingId = "+ item+"";
			rentAreaRepository.delete(sqlRentArea);
			String sqlAssignment = "DELTE FROM assignmentbuilding WHERE buildingId = "+ item+"";
			assignmentBuildingRepository.delete(sqlAssignment);
			buildingRepository.delete(item);
			}
		}
	}

