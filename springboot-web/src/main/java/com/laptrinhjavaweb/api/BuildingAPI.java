package com.laptrinhjavaweb.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.BuildingTypeDTO;
import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.dto.output.UserOutput;
import com.laptrinhjavaweb.emun.TypeBuilding;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.UserService;

@RestController
public class BuildingAPI {
	@Autowired
	IBuildingService buidingService ;
	
	@Autowired
	UserService userService ;
	
// Phương thức get search
	@GetMapping("/buildings")
	public List<BuildingDTO> getBuildings(@RequestParam Map<String, String> requestParams,
			@RequestParam String[] types) {
		BuildingSearchBuilder builder = convertMapToBuilder(requestParams, types);
		return buidingService.getBuildings(builder);
	}

	private BuildingSearchBuilder convertMapToBuilder(Map<String, String> requestParams, String[] types) {
		// NumberOfBasement
		Integer numberOfBasement = requestParams.containsKey("numberOfBasement")
				? (StringUtils.isNotBlank(requestParams.get("numberOfBasement"))
						? Integer.parseInt(requestParams.get("numberOfBasement"))
						: null)
				: null;
		// floorArea
		Integer floorArea = requestParams.containsKey("floorArea")
				? (StringUtils.isNotBlank(requestParams.get("floorArea"))
						? Integer.parseInt(requestParams.get("floorArea"))
						: null)
				: null;
		// rentAreaFrom
		Integer rentAreaFrom = requestParams.containsKey("rentAreaFrom")
				? (StringUtils.isNotBlank(requestParams.get("rentAreaFrom"))
						? Integer.parseInt(requestParams.get("rentAreaFrom"))
						: null)
				: null;
		// rentAreaTo
		Integer rentAreaTo = requestParams.containsKey("rentAreaTo")
				? (StringUtils.isNotBlank(requestParams.get("rentAreaTo"))
						? Integer.parseInt(requestParams.get("rentAreaTo"))
						: null)
				: null;
		// rentPriceFrom
		Integer rentPriceFrom = requestParams.containsKey("rentPriceFrom")
				? (StringUtils.isNotBlank(requestParams.get("rentPriceFrom"))
						? Integer.parseInt(requestParams.get("rentPriceFrom"))
						: null)
				: null;
		// rentPriceTo
		Integer rentPriceTo = requestParams.containsKey("rentPriceTo")
				? (StringUtils.isNotBlank(requestParams.get("rentPriceTo"))
						? Integer.parseInt(requestParams.get("rentPriceTo"))
						: null)
				: null;
		// rentPriceTo
		Long staffId = requestParams.containsKey("staffId")
				? (StringUtils.isNotBlank(requestParams.get("staffId")) ? Long.parseLong(requestParams.get("staffId"))
						: null)
				: null;

		BuildingSearchBuilder buider = BuildingSearchBuilder.builder()
				.name(requestParams.containsKey("name") ? requestParams.get("name") : null)
				.numberOfBasement(numberOfBasement).floorArea(floorArea)
				.district(requestParams.containsKey("district") ? requestParams.get("district") : null)
				.ward(requestParams.containsKey("ward") ? requestParams.get("ward") : null)
				.srteet(requestParams.containsKey("srteet") ? requestParams.get("srteet") : null)
				.direction(requestParams.containsKey("direction") ? requestParams.get("direction") : null)
				.level(requestParams.containsKey("level") ? requestParams.get("level") : null).rentAreaTo(rentAreaTo)
				.rentAreaFrom(rentAreaFrom).rentPriceTo(rentPriceTo).rentPriceFrom(rentPriceFrom)
				.types(types.length != 0 ? types : null)
				.manager(requestParams.containsKey("manager") ? requestParams.get("manager") : null)
				.managerMobile(requestParams.containsKey("managerMobile") ? requestParams.get("managerMobile") : null)
				.staffId(staffId).build();
		return buider;
	}

	// Thêm tòa nhà
	@PostMapping("/building")
	public BuildingDTO addBuilding(@RequestBody BuildingDTO buidBuildingDTO) {
		return buidingService.save(buidBuildingDTO);
	}

	// Sửa tòa nhà
	@PutMapping("/buildings/")
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO buidBuildingDTO) {
		return buidingService.update(buidBuildingDTO);
	}

	// Delete tòa nhà
	@DeleteMapping(value = "/buildings")
	public void deleteNew(@RequestBody long[] ids) {
		buidingService.delete(ids);
	}

	// Giao tòa nhà cho nhân viên
	@PostMapping("/building/assignment")
	public void assignmentBuilding(@RequestBody AssignmentBuildingInput assignmentBuildingInput) {
		buidingService.assignmentBuilding(assignmentBuildingInput);
//		return assignmentBuildingService.assignmentBuilding(assignmentBuildingInput);
	}

//	// Các nhân viên quản lý các tòa nhà
	@GetMapping("/building/{buildingid}/staff")
	public List<UserOutput> getUser(@PathVariable("buildingid") Long id){
		return userService.findAllUserByBuilding(id, "STAFF");

	}
}
