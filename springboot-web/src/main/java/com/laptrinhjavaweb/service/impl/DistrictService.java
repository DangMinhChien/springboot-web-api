package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.emun.District;
import com.laptrinhjavaweb.service.IDistrictService;
@Service
public class DistrictService implements IDistrictService{

	@Override
	public Map<String, String> getDistrict() {
		Map<String, String> results = new HashMap<>();
		for (District district : District.values()) {
				results.put(district.name(), district.getName());
	        }
		return results;
	}

}
