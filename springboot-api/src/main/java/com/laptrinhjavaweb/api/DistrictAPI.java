package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.output.Enum;
import com.laptrinhjavaweb.emun.District;

@RestController
public class DistrictAPI {
	//Danh sách quận
	@GetMapping("/district")
	public List<Enum> getDistrict() {	
		List<Enum> result = new ArrayList<>();
		 for (District d : District.values()) {
			 Enum enum1 = new Enum();
			 enum1.setCode(d.name());
			 enum1.setName(d.getName());
			 result.add(enum1);
	        }
		return result;
	}
}
