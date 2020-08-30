package com.laptrinhjavaweb.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssignmentBuildingInput {
	private Long buildingId ;
	private Long[] staffIds;
}
