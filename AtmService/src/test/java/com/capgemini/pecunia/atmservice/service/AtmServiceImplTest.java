package com.capgemini.pecunia.atmservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.pecunia.atmservice.dao.AtmRepositry;
import com.capgemini.pecunia.atmservice.dto.AtmRegistry;
import com.capgemini.pecunia.atmservice.exception.AccountNotFoundException;
import com.capgemini.pecunia.atmservice.exception.AtmCardNotFoundException;
import com.capgemini.pecunia.atmservice.exception.CardAlreadyExistsException;

@RunWith(SpringRunner.class)
@SpringBootTest
class AtmServiceImplTest {

	@Autowired
	private AtmServiceImpl atmService;
	
	/*
	 * @Autowired AtmRepositry repo;
	 */
	
	@Test
	public void atmCardBlocktest() {
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525263);
		 * atmCard.setAtmNumber(123456); atmCard.setStatus("In-use");
		 * repo.save(atmCard);
		 */
		AtmRegistry find=atmService.blockAtmCard(520000000000L);
		assertEquals(find.getStatus(),"BLOCK");
		
	}
	
	@Test
	public void atmCardBlockNotFoundTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525263);
		 * atmCard.setAtmNumber(123456); atmCard.setStatus("In-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.blockAtmCard(145689);
		assertThrows(AtmCardNotFoundException.class,()->atmService.blockAtmCard(145689));
	}
	
	@Test
	public void atmCardRequestTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525261);
		 * atmCard.setAtmNumber(123457); atmCard.setStatus("BLOCK"); repo.save(atmCard);
		 */
		AtmRegistry find=atmService.requestAtmCard(525263);
		assertEquals(find.getStatus(),"Dispatched");
	}
	
	@Test
	public void atmCardRequestAlreadyExistTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(525273);
		 * atmCard.setAtmNumber(120456); atmCard.setStatus("in-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.requestAtmCard(563120);
		assertThrows(CardAlreadyExistsException.class,()->atmService.requestAtmCard(563120));
	}
	
	@Test
	public void atmCardRequestAccountDoesntExistTest()
	{
		/*
		 * AtmRegistry atmCard=new AtmRegistry(); atmCard.setAccountNumber(595263);
		 * atmCard.setAtmNumber(193456); atmCard.setStatus("in-use");
		 * repo.save(atmCard);
		 */
		//AtmRegistry find=atmService.requestAtmCard(505263);
		assertThrows(AccountNotFoundException.class,()->atmService.requestAtmCard(503120));
	}

}
