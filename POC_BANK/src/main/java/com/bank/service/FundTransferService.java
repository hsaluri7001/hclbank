package com.bank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Account;
import com.bank.entity.AccountTransactions;
import com.bank.exceptionhandler.CommonCustomException;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;

/**
 * @author saluri
 *
 */
@Service
public class FundTransferService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	public Integer transferAmount(AccountTransactions accountTransactions) {
		Integer transactionId = 0;
		Long senderAccountNumber = Long.valueOf(accountTransactions.getSenderAccountNumber());
		Long recieverAccountNumber = Long.valueOf(accountTransactions.getReceiverAccountNummber());
		Account senderAccount = accountRepository.getOne(senderAccountNumber);
		Account receiverAccount = accountRepository.getOne(recieverAccountNumber);
		List<Account> accounts = new ArrayList<>();
		if (senderAccount != null && receiverAccount != null) {
			if (senderAccount.getStatus().equals("ACTIVE") && receiverAccount.getStatus().equals("ACTIVE")) {
				if (senderAccount.getBalance() > accountTransactions.getTransactionAmount()) {
					try {
						Double senderTotalBalance = senderAccount.getBalance();
						senderTotalBalance = senderTotalBalance - accountTransactions.getTransactionAmount();
						Double recieverTotalBalance = receiverAccount.getBalance();
						recieverTotalBalance = recieverTotalBalance + accountTransactions.getTransactionAmount();
						senderAccount.setBalance(senderTotalBalance);
						receiverAccount.setBalance(recieverTotalBalance); 
						accounts.add(senderAccount);
						accounts.add(receiverAccount);
						accountRepository.saveAll(accounts);
						accountTransactions.setSenderAccountNumber(senderAccountNumber + "_db");
						accountTransactions.setReceiverAccountNummber(recieverAccountNumber + "_cr");
						accountTransactions.setTransactionDate(new Date());
						accountTransactions.setTransactionStatus("SUCCESSFUL");
						transactionId = transactionRepository.save(accountTransactions).getTransactionId();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					throw new CommonCustomException("Insufficient funds in your account!");
				}
			} else {
				throw new CommonCustomException("Account is not active. please contact bank!");
			}
		} else {
			throw new CommonCustomException("Account Doesn't exist!");
		}
		return transactionId;
	}
}
