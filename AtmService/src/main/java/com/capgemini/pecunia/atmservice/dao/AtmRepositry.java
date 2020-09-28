package com.capgemini.pecunia.atmservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.atmservice.dto.AtmRegistry;

@Repository
public interface AtmRepositry extends JpaRepository<AtmRegistry,Long>{
	
	//@Query("select atm from AtmRegistry atm where atm.atmNumber = :number")
	AtmRegistry findByAtmNumber(/*@Param("number")*/ long atmNumber);
}
