package com.laptrinhjavaweb.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.dto.MasterDataDTO;
import com.laptrinhjavaweb.emun.TypeBuilding;

public class BuildingTypeMasterData  implements MasterDataUtil {

	@Override
	public List<MasterDataDTO> getMasterDataDTO() {
		List<MasterDataDTO> result = Arrays.stream(TypeBuilding.values())
				.map(item -> {
					MasterDataDTO masterDataDTO = new MasterDataDTO();
					masterDataDTO.setCode(item.name());
					masterDataDTO.setName(item.getName());
					return masterDataDTO;
				}).collect(Collectors.toList());
		return result;	
	}
}
