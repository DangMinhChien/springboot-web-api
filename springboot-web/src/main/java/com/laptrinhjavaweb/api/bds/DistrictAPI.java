package com.laptrinhjavaweb.api.bds;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.emun.District;

@RestController
public class DistrictAPI {
	//Danh sách quận
	@GetMapping("/district")
	public List<DistrictDTO> getDistrict() {	
		List<DistrictDTO> result = new ArrayList<>();
		 for (District d : District.values()) {
			 DistrictDTO districtDTO = new DistrictDTO();
			 districtDTO.setCode(d.name());
			 districtDTO.setName(d.getName());
			 result.add(districtDTO);
	        }
		return result;
	}
}

