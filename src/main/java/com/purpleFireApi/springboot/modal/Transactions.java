package com.purpleFireApi.springboot.modal;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account_txns")
public class Transactions {
	
	@Id
	@Column
	 private int accountId;
	
	@Column
	private String accountNumber;
	
	@Column
	private String description;
	
	@Column 
	private double amount;
	
	@Column
	private Date date;
}
