package com.laptrinhjavaweb.dto.output;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutput {
	private Long id;
	private String userName;
	private String fullName;
	private String phone;
	private String email;
	private Integer status;
	private String checked = "";
	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
}
