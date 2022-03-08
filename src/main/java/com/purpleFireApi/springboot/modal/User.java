package com.purpleFireApi.springboot.modal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name= "tbl_users")
public class User { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Basic
	@Column
	private String name;
	
	@Basic
	@Column
	private String role;
	
	@Basic
	@Column
	private String phoneNumber;
	
	@Basic
	@Column
	private Date DOB;
	
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
//	private List<Account> listAccount = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;
	
	public Integer getId() {
		return userId;
	}
	public void setId(Integer id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", role=" + role + ", phoneNumber=" + phoneNumber + ", DOB=" + DOB
				+ "]";
	}
}
