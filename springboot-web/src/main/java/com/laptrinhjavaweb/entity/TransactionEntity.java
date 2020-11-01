package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1176385795575899319L;

	@Column(name = "code")
	private String code;
	
	@Column(name = "note")
	private String note;

	@OneToMany(mappedBy = "transaction")
	private List<CustomerEntity> news = new ArrayList<>();
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
