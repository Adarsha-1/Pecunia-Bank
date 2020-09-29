package com.capgemini.pecunia.atmservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.atmservice.dao.AtmRepositry;
import com.capgemini.pecunia.atmservice.dto.AtmRegistry;
import com.capgemini.pecunia.atmservice.exception.AccountNotFoundException;
import com.capgemini.pecunia.atmservice.exception.AtmCardNotFoundException;
import com.capgemini.pecunia.atmservice.exception.CardAlreadyExistsException;

@Service
public class AtmServiceImpl implements AtmService {
	
	@Autowired
	AtmRepositry atmRepositry;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public AtmRegistry blockAtmCard(long atmNumber) {
		AtmRegistry atm=null;
		try
		{
			atm=atmRepositry.findByAtmNumber(atmNumber);
			atm.setStatus("BLOCK");
			atmRepositry.save(atm);
		}
		catch(Exception e)
		{
			throw new AtmCardNotFoundException("Atm card not Found i.e ATM Number is: "+atmNumber);
		}
		return atm;
	}

	@Override
	public AtmRegistry requestAtmCard(long accountNumber) {
		// TODO Auto-generated method stub
		List<AtmRegistry> allList=new ArrayList<AtmRegistry>();
		atmRepositry.findAll().forEach(atm->allList.add(atm));
		boolean accountPresent=restTemplate.getForObject("http://account-service/account/valid/"+accountNumber, boolean.class);
		AtmRegistry newAtm=new AtmRegistry();
		if(accountPresent)
		{
			for(AtmRegistry a:allList)
			{
				if(a.getAccountNumber() == accountNumber && a.getStatus().equals("BLOCK"))
				{
					newAtm.setAccountNumber(accountNumber);
					newAtm.setStatus("Dispatched");
					atmRepositry.save(newAtm);
					return newAtm;
				}
				else if(a.getAccountNumber() == accountNumber && a.getStatus().equals("in-use"))
				{
					throw new CardAlreadyExistsException("Card Already exists under the Account NUmber: "+accountNumber);
				}
			}
		}
		throw new AccountNotFoundException("Account number not Found i.e "+accountNumber);
	}

}
