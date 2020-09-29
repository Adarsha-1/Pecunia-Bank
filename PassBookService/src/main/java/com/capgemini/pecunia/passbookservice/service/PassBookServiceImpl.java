package com.capgemini.pecunia.passbookservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.passbookservice.dao.PassBookRepository;
import com.capgemini.pecunia.passbookservice.dto.PassBook;
import com.capgemini.pecunia.passbookservice.dto.Transcation;
import com.capgemini.pecunia.passbookservice.dto.UserTransactions;
import com.capgemini.pecunia.passbookservice.exception.AccountNoLengthException;
import com.capgemini.pecunia.passbookservice.exception.AccountNotFoundException;
import com.capgemini.pecunia.passbookservice.exception.NoTransactionsException;
import com.capgemini.pecunia.passbookservice.exception.ToDateAfterCurrentDateException;
import com.capgemini.pecunia.passbookservice.exception.ToDateException;

@Service
public class PassBookServiceImpl implements PassBookService{

	@Autowired
	PassBookRepository passBookrepo;
	
	@Autowired
	private TransService transService;
	
	@Autowired
	private AccountService accService;
	
	
	@Override
	public List<Transcation> updatePassbook(long accountNumber) {
		if(accountNumber<=1999999999L || accountNumber>9999999999L)
		{
			throw new AccountNoLengthException("Account number should have 10 digits");
		}
		boolean accountPre=accService.accountNumberExists(accountNumber);
		List<Transcation> updatedTransList=new ArrayList<>();
		PassBook updatePassBook=new PassBook();
		if(accountPre)
		{
			
			UserTransactions transactions=transService.transactionList(accountNumber);
			List<Transcation> transactionList=transService.transactionList(accountNumber).getUserTransaction();
			
			PassBook passbook=passBookrepo.findByAccountNumber(accountNumber);
			if(passbook!=null)
			{
				LocalDate updateddate=passbook.getUpdatedDate();
				for(Transcation trans:transactionList)
				{
					if((trans.getTranscationDate()).isAfter(updateddate))
					{
						updatedTransList.add(trans);
					}
				}
				updatePassBook=passbook;
			}
			else
			{
				transactions.getUserTransaction().forEach(trans->updatedTransList.add(trans));
				updatePassBook.setAccountNumber(accountNumber);
			}

			updatePassBook.setUpdatedDate(LocalDate.now());
			passBookrepo.save(updatePassBook);
			
		}
		else
		{
			throw new AccountNotFoundException("Account with Number : "+accountNumber+" is not present");
		}
		if(updatedTransList.isEmpty())
		{
			throw new NoTransactionsException("No recent transaction done after last updation on account number: "+accountNumber);
		}
		return updatedTransList;
	}

	@Override
	public List<Transcation> accountSummary(long accountNumber, LocalDate fromDate, LocalDate toDate) {
		if(accountNumber<=1999999999L || accountNumber>9999999999L)
		{
			throw new AccountNoLengthException("Account number should have 10 digits");
		}
		boolean accountPre=accService.accountNumberExists(accountNumber);
		List<Transcation> updatedTransList=new ArrayList<>();
		if(accountPre)
		{
			UserTransactions transactions=transService.transactionList(accountNumber);
			List<Transcation> transactionList=transactions.getUserTransaction();
			if(toDate.isBefore(fromDate))
			{
				throw new ToDateException("To Date i.e: "+toDate+" should be after from date ");
			}
			if(LocalDate.now().isBefore(toDate))
			{
				throw new ToDateAfterCurrentDateException("ToDate i.e: "+toDate+"should not be after current date");
			}
			for(Transcation trans:transactionList)
			{
				if((trans.getTranscationDate()).isAfter(fromDate) && trans.getTranscationDate().isBefore(toDate) || trans.getTranscationDate().compareTo(fromDate) == 0 || trans.getTranscationDate().compareTo(toDate) == 0)
				{
					updatedTransList.add(trans);
				}
			}
		}
		else
		{
			throw new AccountNotFoundException("Account with Number : "+accountNumber+" is not present");
		}
		if(updatedTransList.isEmpty())
		{
			throw new NoTransactionsException("No Transactions present between "+fromDate+" to "+toDate);
		}
		return updatedTransList;
	}

}
