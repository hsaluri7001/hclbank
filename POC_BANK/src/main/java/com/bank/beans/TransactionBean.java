package com.bank.beans;

/**
 * @author saluri
 *
 */
public class TransactionBean {

	private String senderAccountNumber;
	private String receiverNumber;
	private String monthAndYear;
	public String getSenderAccountNumber() {
		return senderAccountNumber;
	}
	public void setSenderAccountNumber(String senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	public String getReceiverNumber() {
		return receiverNumber;
	}
	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}
	public String getMonthAndYear() {
		return monthAndYear;
	}
	public void setMonthAndYear(String monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
	@Override
	public String toString() {
		return "TransactionBean [senderAccountNumber=" + senderAccountNumber + ", receiverNumber=" + receiverNumber
				+ ", monthAndYear=" + monthAndYear + "]";
	}
	
}
