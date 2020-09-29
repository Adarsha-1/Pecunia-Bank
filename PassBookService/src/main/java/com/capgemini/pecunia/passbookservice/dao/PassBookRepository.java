package com.capgemini.pecunia.passbookservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.passbookservice.dto.PassBook;

@Repository
public interface PassBookRepository extends JpaRepository<PassBook,Long>{
	
	public PassBook findByAccountNumber(long accountNumber);
}
