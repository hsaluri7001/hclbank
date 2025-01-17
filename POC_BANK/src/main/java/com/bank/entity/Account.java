package com.bank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author saluri
 *
 */
@Entity
public class Account {
	@Id
	@SequenceGenerator(name = "ACCOUNT_SEQUENCE", sequenceName = "ACCOUNT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQUENCE")
	private Long accountNumber;
	private Integer branchId;
	private String userName;
	private Double balance;
	private String status;
	private String accountType;
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getBalance() {
		return balance;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
