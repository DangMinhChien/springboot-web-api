package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentareEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6356101200856000591L;
	
	@Column(name="value")
	private Integer value;

	@OneToMany(mappedBy = "rentarea")
	private List<BuildingEntity> news = new ArrayList<>();
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
}
