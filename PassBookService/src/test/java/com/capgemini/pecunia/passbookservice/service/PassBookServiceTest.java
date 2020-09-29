package com.capgemini.pecunia.passbookservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.capgemini.pecunia.passbookservice.dao.PassBookRepository;
import com.capgemini.pecunia.passbookservice.dto.Transcation;
import com.capgemini.pecunia.passbookservice.exception.AccountNotFoundException;
import com.capgemini.pecunia.passbookservice.exception.NoTransactionsException;
import com.capgemini.pecunia.passbookservice.exception.ToDateAfterCurrentDateException;
import com.capgemini.pecunia.passbookservice.exception.ToDateException;

@RunWith(SpringRunner.class)
@SpringBootTest
class PassBookServiceTest {

	@Autowired
	private PassBookServiceImpl passBookService;
	
	@MockBean
	private PassBookRepository passBookRepo;
	
	/*
	 * @Autowired PassBookRepository passBookRepo;
	 * 
	 * @Autowired AccountRepository accountRepo;
	 * 
	 * @Autowired TransactionRepository transRepo;
	 */
	@Test
	void updatePassBookTest()
	{
		List<Transcation> transList=passBookService.updatePassbook(535671);
		assertEquals(4,transList.size());
	}
	
	@Test
	void updatePassBookNotFoundTest()
	{
		/*
		 * Account acc=new Account(); acc.setAccountName("adarsha");
		 * acc.setAmount(6500.00); acc.setAccountNo(234561); accountRepo.save(acc);
		 * Transaction trans=new Transaction(); trans.setAccountBalance(6500.00);
		 * trans.setAccountNo(234561); trans.setTransactionAmount(5000.00);
		 * trans.setTransactionDate(LocalDate.of(2020, 8, 25));
		 * trans.setTransactionStatus("DONE"); trans.setTransactionType("DEBIT");
		 * transRepo.save(trans); PassBook pass=new PassBook();
		 * pass.setAccountNumber(234561); pass.setUpdatedDate(LocalDate.of(2019, 12,
		 * 12)); passBookRepo.save(pass);
		 */
		//List<Transaction> transList=passBookService.updatePassbook(234561);
		assertThrows(AccountNotFoundException.class,()->passBookService.updatePassbook(234561));
		
	}
	
	//@Test
	/*public void updatePassBookUpToDateTest()
	{
		/*
		 * Account acc=new Account(); acc.setAccountName("adarsha");
		 * acc.setAmount(6500.00); acc.setAccountNo(23456); accountRepo.save(acc);
		 * Transaction trans=new Transaction(); trans.setAccountBalance(6500.00);
		 * trans.setAccountNo(23456); trans.setTransactionAmount(5000.00);
		 * trans.setTransactionDate(LocalDate.of(2020, 1, 25));
		 * trans.setTransactionStatus("DONE"); trans.setTransactionType("DEBIT");
		 * transRepo.save(trans); PassBook pass=new PassBook();
		 * pass.setAccountNumber(23456); pass.setUpdatedDate(LocalDate.of(2020, 9, 12));
		 * passBookRepo.save(pass);
		 */
		//List<Transaction> transList=passBookService.updatePassbook(23456);
		//assertThrows(NoTransactionsException.class,()->passBookService.updatePassbook(525263));
		
	//}*/
	
	@Test
	void accountSummaryTest()
	{
		/*
		 * Account acc=new Account(); acc.setAccountName("adarsha");
		 * acc.setAmount(65000.00); acc.setAccountNo(2456); accountRepo.save(acc);
		 * Transaction trans1=new Transaction(); trans1.setAccountBalance(70000.00);
		 * trans1.setAccountNo(2456); trans1.setTransactionAmount(5000.00);
		 * trans1.setTransactionDate(LocalDate.of(2020, 1, 25));
		 * trans1.setTransactionStatus("DONE"); trans1.setTransactionType("DEBIT");
		 * transRepo.save(trans1); Transaction trans=new Transaction();
		 * trans.setAccountBalance(65000.00); trans.setAccountNo(2456);
		 * trans.setTransactionAmount(5000.00);
		 * trans.setTransactionDate(LocalDate.of(2020, 8, 2));
		 * trans.setTransactionStatus("DONE"); trans.setTransactionType("DEBIT");
		 * transRepo.save(trans); PassBook pass=new PassBook();
		 * pass.setAccountNumber(2456); pass.setUpdatedDate(LocalDate.of(2020, 9, 12));
		 * passBookRepo.save(pass);
		 */
		List<Transcation> transList=passBookService.accountSummary(535671, LocalDate.of(2019, 12, 12), LocalDate.of(2020, 07, 05));
		assertEquals(2,transList.size());
		
	}
	
	@Test
	void accountSummaryToDateTest()
	{
		try
		{
			passBookService.accountSummary(552632, LocalDate.of(2019,12,12), LocalDate.of(2019, 02, 12));
		}
		catch(ToDateException e)
		{
			String actualMsg=e.getMessage();
			String expectedMsg="To Date i.e: "+LocalDate.of(2019, 02, 12)+" should be after from date ";
			assertEquals(expectedMsg,actualMsg);
		}
		//assertThrows(ToDateException.class,()->passBookService.accountSummary(552632, LocalDate.of(2019,12,12), LocalDate.of(2019, 02, 12)));
	}
	
	@Test
	void accountSummaryToDateCurrentTest()
	{
		try
		{
			passBookService.accountSummary(552632, LocalDate.of(2019,12,12), LocalDate.of(2021, 02, 12));
		}
		catch(ToDateAfterCurrentDateException e)
		{
			String actualMsg=e.getMessage();
			String expectedMsg="ToDate i.e: "+LocalDate.of(2021, 02, 12)+"should not be after current date";
			assertEquals(expectedMsg,actualMsg);
		}
		//assertThrows(ToDateAfterCurrentDateException.class,()->passBookService.accountSummary(552632, LocalDate.of(2019,12,12), LocalDate.of(2021, 02, 12)));
	}
	
	@Test
	void accountSummaryNoTransactionsTest()
	{
		try
		{
			passBookService.accountSummary(552632, LocalDate.of(2019,11,12), LocalDate.of(2019, 02, 12));
		}
		catch(NoTransactionsException e)
		{
			String actualMsg=e.getMessage();
			String expectedMsg="No Transactions present between "+LocalDate.of(2019,11,12)+" to "+LocalDate.of(2019, 02, 12);
			assertEquals(expectedMsg,actualMsg);
		}
		//assertThrows(ToDateException.class,()->passBookService.accountSummary(552632, LocalDate.of(2019,11,12), LocalDate.of(2019, 02, 12)));
	}

}
