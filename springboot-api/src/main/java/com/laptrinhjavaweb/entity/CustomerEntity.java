package com.laptrinhjavaweb.entity;

//import com.laptrinhjavaweb.annotations.Column;
//import com.laptrinhjavaweb.annotations.Table;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;



//@Table(name = "customer")
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1547526104290208219L;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentcustomer",
            joinColumns = @JoinColumn(name = "customer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false))
    private List<UserEntity> userCustomer = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction")
    private TransactionEntity transaction;
	
//	@Column(name = "id")
//	private Long id;
//	
//	@Column(name = "username")
//	private String userName;
//	
//	@Column(name = "fullname")
//	private String fullName;
//	
//	@Column(name = "phone")
//	private String phone;
//	
//	@Column(name = "email")
//	private String email;
//	
//	@Column(name = "createddate")
//	private Date createdDate;
//	
//	@Column(name = "modifieddate")
//	private Date modifiedDate;
//	
//	@Column(name = "createdby")
//	private String createdBy;
//	
//	@Column(name = "modifiedby")
//	private String modifiedBy;
}
