package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;
@Data
@Table(name = "transaction")
public class TransactionEntity {
	@Column(name = "id")
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "customerid")
	private String customerId;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifieddate")
	private Date modifieddate;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "modifiedby")
	private String modifiedBy;
}
