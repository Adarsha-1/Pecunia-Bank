package com.capgemini.pecunia.atmservice;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.pecunia.atmservice.exception.AtmCardNotFoundException;
import com.capgemini.pecunia.atmservice.service.AtmServiceImpl;

@SpringBootTest
class AtmServiceApplicationTests {

	@Autowired
	private AtmServiceImpl atmService;
	
	@Test
	void atmCardBlockNotFoundTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525263);
		 * atmCard.setAtmNumber(123456); atmCard.setStatus("In-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.blockAtmCard(145689);
		assertThrows(AtmCardNotFoundException.class,()->atmService.blockAtmCard(145689));
	}
}
