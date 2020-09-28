package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dto.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
public List<Customer> findByAadhar(long aadhar);
}
