package com.capgemini.pecunia.atmservice;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.atmservice.dto.AtmRegistry;
import com.capgemini.pecunia.atmservice.exception.AccountNoLengthException;
import com.capgemini.pecunia.atmservice.exception.AccountNotFoundException;
import com.capgemini.pecunia.atmservice.exception.AtmCardNotFoundException;
import com.capgemini.pecunia.atmservice.exception.CardAlreadyExistsException;
import com.capgemini.pecunia.atmservice.service.AtmServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class AtmServiceApplicationTests {

	@Autowired
	private AtmServiceImpl atmService;
	
	
	@Test
	void atmCardBlocktest() {
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525263);
		 * atmCard.setAtmNumber(123456); atmCard.setStatus("In-use");
		 * repo.save(atmCard);
		 */
		AtmRegistry find=atmService.blockAtmCard(520000000000L);
		assertEquals("BLOCK",find.getStatus());
		
	}
	
	@Test
	void atmCardBlockNotFoundTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525263);
		 * atmCard.setAtmNumber(123456); atmCard.setStatus("In-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.blockAtmCard(145689);
		assertThrows(AtmCardNotFoundException.class,()->atmService.blockAtmCard(999999999999L));
	}
	
	@Test
	void atmCardLengthTest()
	{
		try
		{
			atmService.blockAtmCard(12345687L);
		}
		catch(AccountNoLengthException e)
		{
			String expectedMsg="ATM number should have 12 digits";
			String actualMsg=e.getMessage();
			assertEquals(expectedMsg,actualMsg);
		}
	}
	
	@Test
	void atmCardRequestTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525261);
		 * atmCard.setAtmNumber(123457); atmCard.setStatus("BLOCK"); repo.save(atmCard);
		 */
		AtmRegistry find=atmService.requestAtmCard(2000000061);
		assertEquals("Dispatched",find.getStatus());
	}
	
	@Test
	 void atmCardRequestAlreadyExistTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525273);
		 * atmCard.setAtmNumber(120456); atmCard.setStatus("in-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.requestAtmCard(563120);
		assertThrows(CardAlreadyExistsException.class,()->atmService.requestAtmCard(2000000021L));
	}
	
	@Test
	void atmCardRequestAccountDoesntExistTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(595263);
		 * atmCard.setAtmNumber(193456); atmCard.setStatus("in-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.requestAtmCard(505263);
		assertThrows(AccountNotFoundException.class,()->atmService.requestAtmCard(5999999999L));
	}
	
	@Test
	void accountLengthTest()
	{
		try
		{
			atmService.requestAtmCard(1245812L);
		}
		catch(AccountNoLengthException e)
		{
			String expectedMsg="Account number should have 10 digits";
			String actualMsg=e.getMessage();
			assertEquals(expectedMsg,actualMsg);
		}
	}
}
