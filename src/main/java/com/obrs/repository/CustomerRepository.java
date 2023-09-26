package com.obrs.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.obrs.entity.Customer;




@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByUsername(String username);
	
	Optional<Customer> findById(int customerId);
	// List<Customer> findAllCustomers();
	
	 @Query("SELECT c FROM Customer c")
	List<Customer> findAllCustomers();
	
	    // Define custom queries or methods as needed
	
}
