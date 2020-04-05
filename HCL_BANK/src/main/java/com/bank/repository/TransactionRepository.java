package com.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.entity.AccountTransactions;

public interface TransactionRepository extends JpaRepository<AccountTransactions,Integer> {
	
	@Query(value="select * from account_transactions WHERE to_char(TRANSACTION_DATE,'MM-YYYY')=?1 AND SENDER_ACCOUNT_NUMBER=?2",nativeQuery=true)
	public List<AccountTransactions> getDepositTransactions(String monthAndYear,String accountNumber);
	
/*	@Query("select TRANSACTION_ID ,SENDER_ACCOUNT_NUMBER,RECEIVER_ACCOUNT_NUMMBER,TRANSACTION_STATUS,TRANSACTION_TYPE,TRANSACTION_DESC ,TRANSACTION_AMOUNT,TRANSACTION_DATE  from account_transactions WHEREto_char(TRANSACTION_DATE,'MM-YYYY')=? AND RECEIVER_ACCOUNT_NUMMBER=?")
	public List<AccountTransactions> getCreditTransactions(String monthAndYear,String accountNumber);
*/

}
