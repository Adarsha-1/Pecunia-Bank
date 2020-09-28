package com.capgemini.pecunia.passbookservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AccountService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//@HystrixCommand(fallbackMethod="getFallBackAccountPresent")
	public boolean accountNumberExists(long accountNumber)
	{
		boolean accountPresent=restTemplate.getForObject("http://account-service/account/valid/"+accountNumber, boolean.class);
		return accountPresent;
	}
	
	public boolean getFallBackAccountPresent(long accountNumber)
	{
		return false;
	}
}
