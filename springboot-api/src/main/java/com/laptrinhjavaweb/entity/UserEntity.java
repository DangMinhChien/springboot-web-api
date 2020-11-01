package com.laptrinhjavaweb.entity;

//import java.util.Date;
//
//import com.laptrinhjavaweb.annotations.Column;
//import com.laptrinhjavaweb.annotations.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
//@Table(name = "user")
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4988455421375043688L;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();

    @ManyToMany(mappedBy = "userBulding", fetch = FetchType.LAZY)
    private List<UserEntity> usersBulding = new ArrayList<>();
    
    @ManyToMany(mappedBy = "userCustomer", fetch = FetchType.LAZY)
    private List<UserEntity> usersCustomer = new ArrayList<>();
//	@Column(name = "id")
//	private Long id;
//	@Column(name="username")
//	private String userName;
//	@Column(name="password")
//	private String password;
//	@Column(name="fullname")
//	private String fullName;
//	@Column(name="phone")
//	private String phone;
//	@Column(name="email")
//	private String email;
//	@Column(name="status")
//	private Integer status;
//	@Column(name="createddate")
//	private Date createdDate;
//	@Column(name="modifieddate")
//	private Date modifieddate;
//	@Column(name="createdby")
//	private String createdBy;
//	@Column(name="modifiedby")
//	private String modifiedBy;
}
