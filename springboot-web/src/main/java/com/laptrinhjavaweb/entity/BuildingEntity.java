package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "building")
@Data
public class BuildingEntity extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4863494175187305508L;

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

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "bulding_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<UserEntity> userBulding = new ArrayList<>();
	
	@OneToMany(mappedBy = "building")
	private List<RentAreaEntity> rentArea = new ArrayList<>();
	
}
