package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.buider.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.Enum;
import com.laptrinhjavaweb.emun.District;
import com.laptrinhjavaweb.emun.Transaction;
import com.laptrinhjavaweb.emun.TypeBuilding;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingServiceImpl;

@RestController
public class BuildingAPI {
	private IBuildingService buidingService = new BuildingServiceImpl();

// Phương thức get search
	@GetMapping("/buildings")
	public List<BuildingDTO> getBuildings(@RequestParam Map<String, String> requestParams , @RequestParam ArrayList<String> types) {
		BuildingSearchBuilder builder = convertMapToBuilder(requestParams,types);
		return buidingService.getBuildings(builder);
	}
	
//Phương thức Post
//	@PostMapping("/buildings")
//	public List<BuildingDTO> getBuildings(@RequestBody BuildingDTO dto ) {
//		return null;
//	}
	private BuildingSearchBuilder convertMapToBuilder(Map<String, String> requestParams,ArrayList<String> types) {		
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
						
		BuildingSearchBuilder buider = BuildingSearchBuilder.builder()
				.name(requestParams.containsKey("name") ? requestParams.get("name") : null)
				.numberOfBasement(numberOfBasement)
				.floorArea(floorArea)
				.district(requestParams.containsKey("district") ? requestParams.get("district") : null)
				.ward(requestParams.containsKey("ward") ? requestParams.get("ward") : null)
				.srteet(requestParams.containsKey("srteet") ? requestParams.get("srteet") : null)
				.direction(requestParams.containsKey("direction") ? requestParams.get("direction") : null)
				.level(requestParams.containsKey("level") ? requestParams.get("level") : null)
				.rentAreaTo(rentAreaTo)
				.rentAreaFrom(rentAreaFrom)
				.rentPriceTo(rentPriceTo)
				.rentPriceFrom(rentPriceFrom)
				.types(types.isEmpty()? types : null)
				.manager(requestParams.containsKey("manager") ? requestParams.get("manager") : null)
				.managerMobile(requestParams.containsKey("managerMobile") ? requestParams.get("managerMobile") : null)
				.staffUserName(requestParams.containsKey("staffUserName") ? requestParams.get("staffUserName") : null)
				.build();
		return buider;
	}
	
	//Thêm tòa nhà
	@PostMapping("/building")
	public BuildingDTO createBuildings(@RequestBody BuildingDTO buidBuildingDTO) {		
		return buidingService.save(buidBuildingDTO);
	}
	
	//Danh sách quận
	@GetMapping("/district")
	public List<Enum> getDistrict() {	
		List<Enum> result = new ArrayList<Enum>();
		 for (District d : District.values()) {
			 Enum enum1 = new Enum();
			 enum1.setName(d.getName());
			 enum1.setValue(d.getValue());
			 result.add(enum1);
	        }
		return result;
	}
	//Danh sách loại tòa nhà
	@GetMapping("/typebuilding")
	public List<Enum> getTypeBuilding() {	
		List<Enum> result = new ArrayList<Enum>();
		 for (TypeBuilding t : TypeBuilding.values()) {
			 Enum enum1 = new Enum();
			 enum1.setName(t.getName());
			 enum1.setValue(t.getValue());
			 result.add(enum1);
	        }
		return result;
	}
	//Danh loại giao dich
	@GetMapping("/transaction")
	public List<Enum> getTransaction() {	
		List<Enum> result = new ArrayList<Enum>();
		 for (Transaction t : Transaction.values()) {
			 Enum enum1 = new Enum();
			 enum1.setName(t.getName());
			 enum1.setValue(t.getValue());
			 result.add(enum1);
	        }
		return result;
	}
}
