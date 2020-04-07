package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.entity.AccountTransactions;

public interface TransactionRepository extends JpaRepository<AccountTransactions,Integer> {
	
	@Query(value="select * from account_transactions WHERE to_char(TRANSACTION_DATE,'MM-YYYY')=?1 AND SENDER_ACCOUNT_NUMBER=?2",nativeQuery=true)
	public List<AccountTransactions> getDepositTransactions(String monthAndYear,String accountNumber);
	
	@Query(value="select * from account_transactions WHERE to_char(TRANSACTION_DATE,'MM-YYYY')=?1 AND RECEIVER_ACCOUNT_NUMMBER=?2",nativeQuery=true)
	public List<AccountTransactions> getCreditTransactions(String monthAndYear,String accountNumber);

}
