package com.laptrinhjavaweb.buider;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerSearchBuilder {
	private String name;
	
	private String email;
	
	private String phone;
	
	private Long staffId;
	
}
