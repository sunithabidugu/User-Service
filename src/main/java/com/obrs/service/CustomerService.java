package com.obrs.service;
import com.obrs.dto.CustomerDto;
import com.obrs.entity.Customer;
import com.obrs.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    Customer registerCustomer(CustomerDto customerDto);
    public String loginCustomer(String username, String password);
	Customer getCustomerById(int customerId);
	List<Customer> findAllCustomers();

}
