package com.capgemini.pecunia.accountservice.service;

import java.util.List;

import com.capgemini.pecunia.accountservice.dto.Customer;



public interface CustomerService {
	public void addCustomer(Customer customer);
	public List<Customer> findByAadhar(long aadhar);
	public Customer updateCustomer(Customer customer);
	public boolean isAadharNoExists(long aadhar);

	
}
