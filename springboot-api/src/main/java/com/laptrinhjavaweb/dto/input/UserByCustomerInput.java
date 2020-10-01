package com.laptrinhjavaweb.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserByCustomerInput {
	private Long customerId;	
	private String role;
}
