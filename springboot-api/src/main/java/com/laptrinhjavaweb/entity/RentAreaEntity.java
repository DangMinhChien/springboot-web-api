package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;
@Data
@Table(name = "rentarea")
public class RentAreaEntity {
	
	private Long id;
	@Column(name="buildingId")
	private Long buildingId;
	@Column(name="value")
	private Integer value;
	@Column(name="createdDate")
	private Date createdDate;
	@Column(name="modifiedDate")
	private Date modifiedDate;
	@Column(name="createdBy")
	private String createdBy;
	@Column(name="modifiedBy")
	private String modifiedBy;
}
