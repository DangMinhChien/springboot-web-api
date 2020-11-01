package com.laptrinhjavaweb.entity;

//import java.util.Date;
//
//import com.laptrinhjavaweb.annotations.Column;
//import com.laptrinhjavaweb.annotations.Table;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
@Data
//@Table(name = "transaction")
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
	private List<CustomerEntity> cus = new ArrayList<>();
//	@Column(name = "id")
//	private Long id;
//	
//	@Column(name = "code")
//	private String code;
//	
//	@Column(name = "note")
//	private String note;
//	
//	@Column(name = "customerid")
//	private String customerId;
//	
//	@Column(name = "createddate")
//	private Date createdDate;
//	
//	@Column(name = "modifieddate")
//	private Date modifieddate;
//	
//	@Column(name = "createdby")
//	private String createdBy;
//	
//	@Column(name = "modifiedby")
//	private String modifiedBy;
}
