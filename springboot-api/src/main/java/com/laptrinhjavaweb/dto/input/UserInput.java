package com.laptrinhjavaweb.dto.input;

import java.util.Date;

import com.laptrinhjavaweb.dto.output.UserOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
	private Long buildingId;	
	private String role;	
}
