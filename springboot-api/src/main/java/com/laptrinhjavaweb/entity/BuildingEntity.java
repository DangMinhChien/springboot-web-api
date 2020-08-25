package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;

@Data

@Table(name = "building")
public class BuildingEntity {

	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "numberOfBasement")
	private Integer numberOfBasement;
	@Column(name = "floorArea")
	private Integer floorArea;
	@Column(name = "ward")
	private String ward;
	@Column(name = "district")
	private String district;
	@Column(name = "srteet")
	private String srteet;
	@Column(name = "direction")
	private String direction;
	@Column(name = "level")
	private String level;
	@Column(name = "rentPrice")
	private Integer rentPrice;
	@Column(name = "rentPriceDescription")
	private String rentPriceDescription;
	@Column(name = "serviceFee")
	private String serviceFee;
	@Column(name = "carFee")
	private Integer carFee;
	@Column(name = "motoFee")
	private String motoFee;
	@Column(name = "overtimeFee")
	private String overtimeFee;
	@Column(name = "waterFee")
	private String waterFee;
	@Column(name = "electricityFee")
	private String electricityFee;
	@Column(name = "deposit")
	private String deposit;
	@Column(name = "payment")
	private String payment;
	@Column(name = "rentTime")
	private String rentTime;
	@Column(name = "decorationTime")
	private String decorationTime;
	@Column(name = "brokerageFee")
	private Float brokerageFee;
	@Column(name = "types")
	private String types;
	@Column(name = "note")
	private String note;
	@Column(name = "linkBuilding")
	private String linkBuilding;
	@Column(name = "map")
	private String map;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "modifiedDate")
	private Date modifiedDate;
	@Column(name = "createdBy")
	private String createdBy;
	@Column(name = "modifiedBy")
	private String modifiedBy;

}
