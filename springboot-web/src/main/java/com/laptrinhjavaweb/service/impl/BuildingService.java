package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.emun.TypeBuilding;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.IRentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingReponsitoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	@Autowired
	private IBuildingRepository buildingRepository;
	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private IRentAreaRepository rentAreaRepository;

	@Autowired
	private UserRepository userRepository;

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

	@Transactional
	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		String types = buildingDTO.getTypes().stream().map(item -> item).collect(Collectors.joining(" , "));
		buildingEntity.setTypes(types);

		if (buildingDTO.getRentArea() != null && !buildingDTO.getRentArea().isEmpty()) {
			List<RentAreaEntity> areaEntities = new ArrayList<>();
			String rentArea = buildingDTO.getRentArea();
			String[] valueRentArea = rentArea.split(",");
			// Insert RentArea
			for (String value : valueRentArea) {
				RentAreaEntity rentAreaEntity = new RentAreaEntity();
				rentAreaEntity.setValue(Integer.parseInt(value));
				rentAreaEntity.setBuilding(buildingEntity);
				areaEntities.add(rentAreaEntity);
			}
			buildingEntity.setRentArea(areaEntities);
		}
		buildingEntity = buildingRepository.save(buildingEntity);
		BuildingDTO dto = buildingConverter.convertToDto(buildingEntity);
		return dto;
	}

	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item))
				.collect(Collectors.toList());
		return results;
	}

	@Transactional
	@Override
	public BuildingDTO update(BuildingDTO buildingDTO) {
		BuildingEntity updatebuilding = buildingConverter.convertToEntity(buildingDTO);
		BuildingEntity oldbuilding = buildingRepository.findOne(buildingDTO.getId());
		updatebuilding.setModifiedBy(oldbuilding.getModifiedBy());
		updatebuilding.setModifiedDate(oldbuilding.getModifiedDate());
		rentAreaRepository.deleteByBuildingEntityId(buildingDTO.getId());
		String rentArea = buildingDTO.getRentArea();
		String[] valueRentArea = rentArea.split(",");
		List<RentAreaEntity> areaEntities = new ArrayList<>();
		// Insert RentArea
		for (String value : valueRentArea) {
			RentAreaEntity rentAreaEntity = new RentAreaEntity();
			rentAreaEntity.setValue(Integer.parseInt(value));
			rentAreaEntity.setBuilding(updatebuilding);
			areaEntities.add(rentAreaEntity);
		}
		String types = buildingDTO.getTypes().stream().map(item -> item).collect(Collectors.joining(" , "));
		updatebuilding.setTypes(types);
		updatebuilding.setRentArea(areaEntities);
		buildingRepository.save(updatebuilding);
		return buildingDTO;
	}

	@Transactional
	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			List<RentAreaEntity> areaEntities = rentAreaRepository.findByBuilding_Id(item);
			for (RentAreaEntity areaEntity : areaEntities) {
				rentAreaRepository.delete(areaEntity);
			}
			buildingRepository.deleteAssignmentByIdNative(item);
			buildingRepository.delete(item);
		}
	}

	@Transactional
	@Override
	public void assignmentBuilding(AssignmentBuildingInput assignmentBuildingInput) {
		List<UserEntity> userEntities = userRepository
				.findByUsersBuilding_IdAndRole_Id(assignmentBuildingInput.getBuildingId(), "staff");
		List<Long> oldUsers = new ArrayList<>();
		for (UserEntity userEntity : userEntities) {
			oldUsers.add(userEntity.getId());
		}
		List<Long> newUsers = new ArrayList<>();
		Long[] ids = assignmentBuildingInput.getStaffIds();
		for (int i = 0; i < ids.length; i++) {
			newUsers.add(ids[i]);
		}
		List<Long> checkedUsers = getIsCheckedUsers(oldUsers, newUsers);
		List<Long> uncheckedUsers = getIsUncheckedUsers(oldUsers, newUsers);
		if (!uncheckedUsers.isEmpty()) {
			for (Long staffId : uncheckedUsers) {
				buildingRepository.deleteAssignmentByBuildingIdAndStaffIdNative(assignmentBuildingInput.getBuildingId(),
						staffId);
			}
		}
		if (!checkedUsers.isEmpty()) {
			for (Long staffId : checkedUsers) {
				buildingRepository.insertAssignment(assignmentBuildingInput.getBuildingId(), staffId);
			}
		}
	}

	private List<Long> getIsCheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long newobj : newUsers) {
			if (!oldUsers.contains(newobj)) {
				result.add(newobj);
			}
		}
		return result;
	}

	private List<Long> getIsUncheckedUsers(List<Long> oldUsers, List<Long> newUsers) {
		List<Long> result = new ArrayList<>();
		for (Long oldobj : oldUsers) {
			if (!newUsers.contains(oldobj)) {
				result.add(oldobj);
			}
		}
		return result;
	}

}
