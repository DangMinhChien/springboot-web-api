package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;
@Data
@Table(name = "rentarea")
public class RentAreaEntity {
	@Column(name = "id")
	private Long id;
	@Column(name="buildingid")
	private Long buildingId;
	@Column(name="value")
	private Integer value;
	@Column(name="createddate")
	private Date createdDate;
	@Column(name="modifieddate")
	private Date modifiedDate;
	@Column(name="createdby")
	private String createdBy;
	@Column(name="modifiedby")
	private String modifiedBy;
}
