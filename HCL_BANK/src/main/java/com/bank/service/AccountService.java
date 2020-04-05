package com.bank.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.beans.AccountInfo;
import com.bank.beans.TransactionBean;
import com.bank.entity.Account;
import com.bank.entity.AccountTransactions;
import com.bank.entity.Customer;
import com.bank.exceptionhandler.CommonCustomException;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;

/**
 * @author saluri
 *
 */
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	public Customer getAccountDetails(Long accountNumber)throws Exception {
		Account accountEntity = null;
		Customer customerEntity = null;
		try {
			accountEntity = accountRepository.getOne(accountNumber);
			if(accountEntity==null) {
				throw new CommonCustomException("Account Doesn't exist!");
			}
			 customerEntity=accountEntity.getCustomer();
		}
		catch(Exception e) {
			throw new CommonCustomException("Account Doesn't exist! please contact your home branch");
		}
		return customerEntity;
	}

	public AccountInfo createAccount(Customer customerEntity){
		AccountInfo accountInfo = null;
		try {
			if (customerEntity != null) {
				Set<Account> accounts = customerEntity.getAccounts();
				accounts.forEach(
						account -> account.setUserName(customerEntity.getFirstName() + customerEntity.getLastName()));
				customerEntity.setAccounts(accounts);
				Set<Account> account = customerRepository.save(customerEntity).getAccounts();
				accountInfo = new AccountInfo();
				for (Account acc : account) {
					accountInfo.setAccountNumber(acc.getAccountNumber());
					accountInfo.setUserName(acc.getUserName());
					accountInfo.setStatus(acc.getStatus());
					accountInfo.setAccountType(acc.getAccountType());
				}
			}
		} catch (Exception e) {
			new CommonCustomException("Error in creating account. please try after some time!");
		}
		return accountInfo;
	}
	public List<AccountTransactions> getAccountTransactions(TransactionBean transactionBean){
		String senderAccountNumber=transactionBean.getSenderAccountNumber()+"_db";
		System.out.println(senderAccountNumber);
		System.out.println(transactionBean.getMonthAndYear());
		List<AccountTransactions> depositTransactions=null;
		try {
		depositTransactions=transactionRepository.getDepositTransactions(transactionBean.getMonthAndYear(),senderAccountNumber);
		}catch(Exception e){
			e.printStackTrace();
		}
		return depositTransactions;
	}

}