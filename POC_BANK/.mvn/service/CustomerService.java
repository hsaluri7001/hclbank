package com.hcl.service;

import org.springframework.stereotype.Service;

import com.bank.entity.CustomerEntity;
import com.bank.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	
	public Long createAccountForCustomer(CustomerEntity customerEntity) {
		return null;
	}
	
}
