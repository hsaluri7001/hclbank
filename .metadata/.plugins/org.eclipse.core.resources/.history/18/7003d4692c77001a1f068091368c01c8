
package com.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.beans.AccountInfo;
import com.bank.beans.TransactionBean;
import com.bank.entity.AccountTransactions;
import com.bank.entity.Customer;
import com.bank.service.AccountService;
import com.bank.service.FundTransferService;

/**
 * @author saluri
 *
 */
@RestController
@RequestMapping("/hclbank")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private FundTransferService fundTransferService;
	
	
	@GetMapping("/getInfo/{accountNumber}")
	public ResponseEntity<Customer> getAccountDetails(@PathVariable Long accountNumber) throws Exception{
		Customer customerEntity=accountService.getAccountDetails(accountNumber);
		return new ResponseEntity<Customer>(customerEntity, HttpStatus.OK);
	}
	@PostMapping("/registration")
	public ResponseEntity<AccountInfo> createAccount(@RequestBody Customer customer) {
		AccountInfo accountInfo=accountService.createAccount(customer);
		return new ResponseEntity<AccountInfo>(accountInfo,HttpStatus.OK);
	}
	@PostMapping("fundTransfer")
	public ResponseEntity<Integer> tranferMount(@RequestBody AccountTransactions accountTrasaction){
		Integer transactionId=fundTransferService.transferAmount(accountTrasaction);
		return new ResponseEntity<Integer>(transactionId,HttpStatus.OK);
	}
	@GetMapping("/getTransactions")
	public ResponseEntity<List<AccountTransactions>> getTransactions(@RequestBody TransactionBean transactionBean){
		List<AccountTransactions> accountTransactions= accountService.getAccountTransactions(transactionBean);
		return new ResponseEntity<List<AccountTransactions>>(accountTransactions,HttpStatus.OK);
	}
}
