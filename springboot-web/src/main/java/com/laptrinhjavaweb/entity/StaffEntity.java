package com.laptrinhjavaweb.entity;

import java.sql.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;
@Data
@Table(name = "user")
public class StaffEntity {
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "status")
	private Integer status;
	@Column(name = "createddate")
	private Date createdDate;
	@Column(name = "modifieddate")
	private Date modifieddate;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String modifiedBy;
}
