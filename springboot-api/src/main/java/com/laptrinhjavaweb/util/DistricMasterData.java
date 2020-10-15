package com.laptrinhjavaweb.util;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.MasterDataDTO;
import com.laptrinhjavaweb.emun.District;

public class DistricMasterData implements MasterDataUtil {

	@Override
	public List<MasterDataDTO> getMasterDataDTO() {
		List<MasterDataDTO> result = new ArrayList<>();
		 for (District d : District.values()) {
			 MasterDataDTO masterDataDTO = new MasterDataDTO();
			 masterDataDTO.setCode(d.name());
			 masterDataDTO.setName(d.getName());
			 result.add(masterDataDTO);
	        }
		return result;
	}

}
