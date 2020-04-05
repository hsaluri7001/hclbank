package com.bank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_TRANSACTIONS")
public class AccountTransactions {
	@Id
	@SequenceGenerator(name="TRANSACTION_SEQUNECE",sequenceName="TRANSACTION_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="TRANSACTION_SEQUNECE")
	private Integer transactionId;
	private String senderAccountNumber;
	private String receiverAccountNummber;
	private String transactionStatus;
	private String transactionType;
	private String transactionDesc;
	private Double transactionAmount;
	private Date transactionDate;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getTransactionDesc() {
		return transactionDesc;
	}
	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
	public Double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getSenderAccountNumber() {
		return senderAccountNumber;
	}
	public void setSenderAccountNumber(String senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	public String getReceiverAccountNummber() {
		return receiverAccountNummber;
	}
	public void setReceiverAccountNummber(String receiverAccountNummber) {
		this.receiverAccountNummber = receiverAccountNummber;
	}
	
}
