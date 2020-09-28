package com.capgemini.pecunia.accountservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.pecunia.accountservice.dao.AccountRepository;
import com.capgemini.pecunia.accountservice.dto.Account;
import com.capgemini.pecunia.accountservice.dto.Customer;
import com.capgemini.pecunia.accountservice.exceptions.AadharNotFoundException;
import com.capgemini.pecunia.accountservice.exceptions.AccountNoNotFoundException;



@Service
public class AccountServiceImpl implements AccountService {
@Autowired
private CustomerService customerService;
@Autowired
private AccountRepository accountDao;
	public Account addAccount(Customer customer) throws AadharNotFoundException
	{
		Account account = new Account();
		if(customerService.findByAadhar(customer.getAadhar()).size()==0)
		{
		customerService.addCustomer(customer);
		
		
		account.setAadhar(customer.getAadhar());
		account.setStatus("open");
		account.setAmount(0);
		account.setBranchId(1001);
		account.setIfsc("PECU0000123");
	    account.setAccountType("savings");
		accountDao.save(account);
		return account;
		
		}
		else
		{
			if(accountDao.findByAadhar(customer.getAadhar()).get(0).getStatus()=="closed")
			{
				account = accountDao.findByAadhar(customer.getAadhar()).get(0);
				account.setStatus("open");
				return account;
			}
			else throw new AadharNotFoundException("aadhar number "+customer.getAadhar()+" already exists");
		}
	}
	

  public boolean deleteAccount(long accountNo)
  {
	  if(isAccountNoExists(accountNo))
	  {
		  
	  List<Account> account = accountDao.findByAccountNo(accountNo);
	  account.get(0).setAccountType("closed");
	  accountDao.save(account.get(0));
	  return true;
	  }
	  else
		  return false;
	  
  }
  public boolean isAccountNoExists(long accountNo)
  {
	  List<Account> account = accountDao.findByAccountNo(accountNo);
		 if(account.size()==0)
		 {
			
			 return false;
		 }
		 else
		 {
			 if(account.get(0).getStatus()=="closed")
			 {
			
				return false; 
			 }
			 else
			 {
			
				 return true;
			 }
		 }

  }
  public Account updateAccount(Account account) throws AccountNoNotFoundException
  {
	  if(isAccountNoExists(account.getAccountNo()))
	  return accountDao.saveAndFlush(account);
	  else
		  throw new AccountNoNotFoundException("Account with number"+account.getAccountNo()+" does not exists");
  }
  public Account getAccountByAccountNo(long accountNo) throws AccountNoNotFoundException
  {
	  if(isAccountNoExists(accountNo))
	  {
		  return accountDao.findByAccountNo(accountNo).get(0);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  public Customer updateCustomer(Customer customer,long accountNo) throws AccountNoNotFoundException
  {
	  if(accountDao.findByAccountNo(accountNo).size()>0)
	  {
		  return customerService.updateCustomer(customer);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  public Customer getCustomerDetailsByAccountNumber(long accountNo) throws AccountNoNotFoundException
  {
	  if(isAccountNoExists(accountNo))
	  {
		  Account account = accountDao.findByAccountNo(accountNo).get(0);
		  return customerService.findByAadhar(account.getAadhar()).get(0);
	  }
	  else
		  throw new AccountNoNotFoundException("Account with number"+accountNo+" does not exists");
  }
  
//  public Customer updateCustomerName(long accountNo, String name)
//  {
//	  if(isAccountNoExists(accountNo))
//	  {
//		  long aadhar = accountDao.findByAccountNo(accountNo).get(0).getAadhar();
//		  return customerService.updateName(aadhar, name);
//		  
//	  }
//	  else
//		  return null;
//  }
//  public Customer updateCustomerContact(long accountNo,long contact)
//  {
//	  if(isAccountNoExists(accountNo))
//	  {
//		  long aadhar = accountDao.findByAccountNo(accountNo).get(0).getAadhar();
//		  return customerService.updateContact(aadhar, contact);
//		  
//	  }
//	  else
//		  return null;
//
//  }
}

