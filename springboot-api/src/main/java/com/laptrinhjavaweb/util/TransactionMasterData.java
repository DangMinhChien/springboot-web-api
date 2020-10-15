package com.laptrinhjavaweb.util;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.MasterDataDTO;
import com.laptrinhjavaweb.emun.Transaction;

public class TransactionMasterData  implements MasterDataUtil{

	@Override
	public List<MasterDataDTO> getMasterDataDTO() {
		List<MasterDataDTO> result = new ArrayList<>();
		 for (Transaction t : Transaction.values()) {
			 MasterDataDTO masterDataDTO = new MasterDataDTO();
			 masterDataDTO.setCode(t.name());
			 masterDataDTO.setName(t.getName());
			 result.add(masterDataDTO);
	        }
		return result;
	}

}
