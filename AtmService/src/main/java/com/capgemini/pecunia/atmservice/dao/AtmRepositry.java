package com.capgemini.pecunia.atmservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.atmservice.dto.AtmRegistry;

@Repository
public interface AtmRepositry extends JpaRepository<AtmRegistry,Long>{
	
	//@Query("select atm from AtmRegistry atm where atm.atmNumber = :number")
	AtmRegistry findByAtmNumber(/*@Param("number")*/ long atmNumber);
}
