package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;

import com.laptrinhjavaweb.dto.BuildingDTO.BuildingDTOBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentAreaDTO {
	private Long id;
	private Long buildingId;
	private Integer value;
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
}
