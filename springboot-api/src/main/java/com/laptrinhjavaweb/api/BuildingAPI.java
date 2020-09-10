package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.input.AssignmentBuildingInput;
import com.laptrinhjavaweb.emun.District;
import com.laptrinhjavaweb.emun.Transaction;
import com.laptrinhjavaweb.emun.TypeBuilding;
import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.AssignmentBuildingServiceImpl;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;
import com.laptrinhjavaweb.dto.output.Enum;

@RestController
public class BuildingAPI {
	private IBuildingService buidingService = new BuildingServiceImpl();
	private IAssignmentBuildingService assignmentBuildingService = new AssignmentBuildingServiceImpl();

// Phương thức get search
	@GetMapping("/buildings")
	public List<BuildingDTO> getBuildings(@RequestParam Map<String, String> requestParams,
			@RequestParam String[] types) {
		BuildingSearchBuilder builder = convertMapToBuilder(requestParams, types);
		return buidingService.getBuildings(builder);
	}

//Phương thức Post
//	@PostMapping("/buildings")
//	public List<BuildingDTO> getBuildings(@RequestBody BuildingDTO dto ) {
//		return null;
//	}
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
	public Boolean updateBuilding(@RequestBody BuildingDTO buidBuildingDTO) {
		return buidingService.update(buidBuildingDTO);
	}

	// Delete tòa nhà
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		buidingService.delete(ids);
	}

	// Giao tòa nhà cho nhân viên
	@PostMapping("/building/assignment")
	public Boolean assignmentBuilding(@RequestBody AssignmentBuildingInput assignmentBuildingInput) {
		return assignmentBuildingService.assignmentBuilding(assignmentBuildingInput);
	}

	// Danh sách loại tòa nhà
	@GetMapping("/building-type")
	public List<Enum> getTypeBuilding() {
		List<Enum> result = new ArrayList<>();
		for (TypeBuilding t : TypeBuilding.values()) {
			Enum enum1 = new Enum();
			enum1.setCode(t.name());
			enum1.setName(t.getName());
			result.add(enum1);
		}
		return result;
	}

}
