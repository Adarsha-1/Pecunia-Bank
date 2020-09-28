package com.capgemini.pecunia.accountservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.accountservice.dto.Account;
import com.capgemini.pecunia.accountservice.dto.Customer;
import com.capgemini.pecunia.accountservice.service.AccountService;
import com.capgemini.pecunia.accountservice.service.CustomerService;

@RestController
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	Logger logger = LoggerFactory.getLogger(AccountController.class);

	@PostMapping("/add")
	public ResponseEntity<Account> addAccount(@RequestBody @Valid Customer customer) {
		logger.info("Adding new customer");
		Account account = accountService.addAccount(customer);
		return ResponseEntity.ok(account);
	}

	@DeleteMapping("/delete/{accountNo}")
	public boolean deleteAccount(@PathVariable long accountNo) {
		logger.info("deleting account with accNo" + accountNo);

		return accountService.deleteAccount(accountNo);
	}

	@PutMapping("/update")
	public Account updateAccount(@RequestBody Account account) {
		logger.info("updating account with accountNo" + account.getAccountNo());
		return accountService.updateAccount(account);
	}

	@GetMapping("/account/valid/{accountNo}")
	public boolean isAccountNoExists(@PathVariable long accountNo) {
		logger.info("Checking account with accountNo " + accountNo + " exists or not");
		return accountService.isAccountNoExists(accountNo);
	}

	@GetMapping("/account/accountNo/{accountNo}")
	public Account getAccountByAccountNo(@PathVariable long accountNo) {
		logger.info("fetching account with accountNo " + accountNo);
		return accountService.getAccountByAccountNo(accountNo);
	}

	@PutMapping("/update/customer/{accountNo}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable long accountNo) {
		logger.info("updating details of customer with accountNo " + accountNo);
		return accountService.updateCustomer(customer, accountNo);
	}

	@GetMapping("aadhar/valid/{aadhar}")
	public boolean isAadharNumberExists(@PathVariable long aadhar) {
		logger.info("checking aadhar number " + aadhar + " exists or not");
		return customerService.isAadharNoExists(aadhar);
	}

	@GetMapping("/customer/accountNo/{accountNo}")
	public Customer getCustomerDetailsByAccountNo(@PathVariable long accountNo) {
		return accountService.getCustomerDetailsByAccountNumber(accountNo);
	}
//@PutMapping()
//public Customer updateCustomerName(@PathVariable long accountNo,@PathVariable String name)
//{
// return accountService.updateCustomerName(accountNo, name);
//}
//@PutMapping()
//public Customer updateCustomerContact(@PathVariable long accountNo,@PathVariable long contact)
//{
//	return accountService.updateCustomerContact(accountNo, contact);
//}

}
