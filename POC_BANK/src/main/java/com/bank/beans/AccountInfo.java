package com.bank.beans;

/**
 * @author saluri
 *
 */
public class AccountInfo {

	private String userName;
	private Long accountNumber;
	private String status;
	private String accountType;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
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

	@Override
	public String toString() {
		return "AccountStatus [userName=" + userName + ", accountNumber=" + accountNumber + ", status=" + status
				+ ", accountType=" + accountType + "]";
	}

}
