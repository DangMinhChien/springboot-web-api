package com.laptrinhjavaweb.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserByBuildingInput {
	private Long buildingId;	
	private String role;	
}
