package com.laptrinhjavaweb.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
	private Long id;

	private String userName;

	private String password;

	private String fullName;

	private String phone;

	private String email;

	private Integer status;

	private Date createdDate;

	private Date modifieddate;

	private String createdBy;

	private String modifiedBy;
}
