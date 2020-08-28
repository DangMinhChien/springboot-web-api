package com.laptrinhjavaweb.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import com.laptrinhjavaweb.service.impl.AssignmentBuildingServiceImpl;

@RestController
public class AssignmentBuidingAPI {
	private IAssignmentBuildingService assignmentBuildingService = new AssignmentBuildingServiceImpl();
	//Lưu thay đổi giao tòa nhà cho nhân viên
	@PostMapping("/assignment_building")
	public AssignmentBuildingDTO assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {		
		return assignmentBuildingService.save(assignmentBuildingDTO);
	}
}
