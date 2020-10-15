package com.laptrinhjavaweb.dto.output;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailOutput {
	private Long id;
	
	private String userName;
	
	private String fullName;
	
	private String phone;

	private String email;
	
	private List<String> careCustomer;
	
	private List<String> goAndSee;

	private Date createdDate;
	
	private Date modifieddate;

	private String createdBy;

	private String modifiedBy;
}
