package com.capgemini.pecunia.atmservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.atmservice.dto.AtmRegistry;
import com.capgemini.pecunia.atmservice.service.AtmServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/atm")
public class AtmServiceController {
	
	@Autowired
	AtmServiceImpl atmService;
	
	Logger log=LoggerFactory.getLogger(AtmServiceController.class);
	
	@ApiOperation(value="Blocking atm card")
	@GetMapping("/{number}")
	public AtmRegistry blockAtm(@ApiParam(value="Atm number is in long format")@PathVariable("number") long atmNumber)
	{
		String str="Blocking tha atm card number: "+atmNumber;
		log.info(str);
		return atmService.blockAtmCard(atmNumber);
	}
	
	@ApiOperation(value="Requesting for new Atm")
	@GetMapping("/request/{accountNumber}")
	public AtmRegistry requestAtm(@ApiParam(value="account number is in long format")@PathVariable("accountNumber") long accountNumber)
	{
		String str="Requesting an atm card for account number : "+accountNumber;
		log.info(str);
		return atmService.requestAtmCard(accountNumber);
	}
}
