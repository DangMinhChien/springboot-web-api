package com.laptrinhjavaweb.entity;

//import java.util.Date;
//
//import com.laptrinhjavaweb.annotations.Column;
//import com.laptrinhjavaweb.annotations.Table;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
@Data
//@Table(name = "rentarea")
@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6356101200856000591L;
	
	@Column(name="value")
	private Integer value;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building")
    private BuildingEntity building;
//	@Column(name = "id")
//	private Long id;
//	@Column(name="buildingid")
//	private Long buildingId;
//	@Column(name="value")
//	private Integer value;
//	@Column(name="createddate")
//	private Date createdDate;
//	@Column(name="modifieddate")
//	private Date modifiedDate;
//	@Column(name="createdby")
//	private String createdBy;
//	@Column(name="modifiedby")
//	private String modifiedBy;
}
