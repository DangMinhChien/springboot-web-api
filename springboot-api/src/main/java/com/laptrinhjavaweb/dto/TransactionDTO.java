package com.laptrinhjavaweb.dto;

import java.util.Date;

import com.laptrinhjavaweb.dto.RentAreaDTO.RentAreaDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDTO extends MasterDataDTO{
	private Long id;
	
	private String code;
	
	private String note;
	
	private String customerId;
	
	private Date createdDate;

	private Date modifieddate;

	private String createdBy;

	private String modifiedBy;
}
