package com.purpleFireApi.springboot.modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "bank_accounts")
//@SecondaryTables({
//	@SecondaryTable(name = "tbl_users")})
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int accountId;
	
	///@Column(table="tbl_users", name = "user_id")
	//private String userId;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "user.username")
	//private User user;
	//@Column(table = "tbl_users")
	////private String uid;
	
	@Column(columnDefinition="CHAR(1) NOT NULL COMMENT 'C- Current, S-Saving '")
	private String accountType;
	
	@Column(columnDefinition = "VARCHAR(16) NOT NULL")
	private String accountNumber;
	
	@Column
	private String IBAN;
	
	@Column
	private double  balance;
	
	@Column(columnDefinition = "VARCHAR(20) NOT NULL")
	private String currency;
}
