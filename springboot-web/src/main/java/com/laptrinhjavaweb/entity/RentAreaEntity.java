package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "rentarea")
@Data
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
	
}
