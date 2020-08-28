package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.repository.IAssignmemtBuildingRepository;
import com.laptrinhjavaweb.repository.impl.AssignmemtBuildingImpl;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;

public class AssignmentBuildingServiceImpl implements IAssignmentBuildingService {
	private IAssignmemtBuildingRepository assignmemtBuildingRepository = new AssignmemtBuildingImpl();
	@Override
	public void save(AssignmentBuildingDTO assignmentBuildingDTO) {
		AssignmentBuildingDTO dto = new AssignmentBuildingDTO();
		List<AssignmentBuildingEntity> assignmentBuildingEntities= new ArrayList<>();
		List<Long> staffIds = assignmentBuildingDTO.getStaffIds();
		for (Long staffId  : staffIds) {
			AssignmentBuildingEntity entity = new AssignmentBuildingEntity();
			entity.setId(assignmentBuildingDTO.getId());
			entity.setBuildingId(assignmentBuildingDTO.getBuildingId());
			entity.setStaffId(staffId);
			entity.setCreatedBy(assignmentBuildingDTO.getCreatedBy());
			entity.setCreatedDate(assignmentBuildingDTO.getCreatedDate());
			entity.setModifiedBy(assignmentBuildingDTO.getModifiedBy());
			entity.setModifiedDate(assignmentBuildingDTO.getCreatedDate());
			assignmentBuildingEntities.add(entity);
		}
		for (AssignmentBuildingEntity  assignmentBuilding: assignmentBuildingEntities) {
			if (assignmentBuilding.getId()==null) {
				assignmemtBuildingRepository.save(assignmentBuilding);	
			}else {
				assignmemtBuildingRepository.update(assignmentBuilding);
			}		
		}
	}

}
