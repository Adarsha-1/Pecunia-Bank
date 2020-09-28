package com.capgemini.pecunia.accountservice.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.pecunia.accountservice.dto.Account;
import com.capgemini.pecunia.accountservice.dto.Customer;
import com.capgemini.pecunia.accountservice.exceptions.AccountNoNotFoundException;


public interface AccountService {
	public Account addAccount(Customer customer);
	public boolean deleteAccount(long accountNo);
	public boolean isAccountNoExists(long accountNo);
	public Account updateAccount(Account account);
	public Account getAccountByAccountNo(long accountNo) throws AccountNoNotFoundException;
	 public Customer updateCustomer(Customer customer,long accountNo);
	 public Customer getCustomerDetailsByAccountNumber(long accountNo) throws AccountNoNotFoundException;
//	public Customer updateCustomerName(long accountNo, String name);
//	public Customer updateCustomerContact(long accountNo,long contact);
}
