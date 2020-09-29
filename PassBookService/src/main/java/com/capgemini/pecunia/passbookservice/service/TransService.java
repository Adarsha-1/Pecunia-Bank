package com.capgemini.pecunia.passbookservice.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.passbookservice.dto.Transcation;
import com.capgemini.pecunia.passbookservice.dto.UserTransactions;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TransService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="getFallBackTransactionList")
	public UserTransactions transactionList(long accountNumber)
	{
		return restTemplate.getForObject("http://transaction-service/transactionList/"+accountNumber, UserTransactions.class);
	}
	
	public UserTransactions getFallBackTransactionList(long accountNumber)
	{
		return new UserTransactions(Arrays.asList(new Transcation(0L,0L," ",0.0,0.0,LocalDate.now(),"Transactions not found")));
	}
	
}
