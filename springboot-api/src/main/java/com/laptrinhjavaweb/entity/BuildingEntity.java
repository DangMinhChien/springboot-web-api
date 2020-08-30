package com.laptrinhjavaweb.entity;

import java.util.Date;

import com.laptrinhjavaweb.annotations.Column;
import com.laptrinhjavaweb.annotations.Table;

import lombok.Data;

@Data

@Table(name = "building")
public class BuildingEntity {
	@Column(name = "id")
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
	@Column(name = "rentpricedescription")
	private String rentPriceDescription;
	@Column(name = "servicefee")
	private String serviceFee;
	@Column(name = "carfee")
	private Integer carFee;
	@Column(name = "motofee")
	private String motoFee;
	@Column(name = "overtimefee")
	private String overtimeFee;
	@Column(name = "waterfee")
	private String waterFee;
	@Column(name = "electricityfee")
	private String electricityFee;
	@Column(name = "deposit")
	private String deposit;
	@Column(name = "payment")
	private String payment;
	@Column(name = "renttime")
	private String rentTime;
	@Column(name = "decorationtime")
	private String decorationTime;
	@Column(name = "brokeragefee")
	private Float brokerageFee;
	@Column(name = "types")
	private String types;
	@Column(name = "note")
	private String note;
	@Column(name = "linkduilding")
	private String linkBuilding;
	@Column(name = "map")
	private String map;
	@Column(name = "avatar")
	private String avatar;
	@Column(name = "createddate")
	private Date createdDate;
	@Column(name = "modifieddate")
	private Date modifiedDate;
	@Column(name = "createdby")
	private String createdBy;
	@Column(name = "modifiedby")
	private String modifiedBy;

}
