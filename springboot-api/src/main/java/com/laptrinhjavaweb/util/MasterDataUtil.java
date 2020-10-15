package com.laptrinhjavaweb.util;

import java.util.List;

import com.laptrinhjavaweb.dto.MasterDataDTO;

public interface MasterDataUtil {
	static MasterDataUtil of(String code) {
		if (code.equals("districts")) {
			return new DistricMasterData();
		} else if (code.equals("buildingtype")) {
			return new BuildingTypeMasterData();
		} else if (code.equals("transaction")) {
			return new BuildingTypeMasterData();
		}
		return null;
	}

	List<MasterDataDTO> getMasterDataDTO();
}
