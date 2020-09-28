package com.capgemini.pecunia.passbookservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.passbookservice.dto.Transaction;


@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Long>{
	public List<Transaction> findByAccountNo(long accountNo);
}
