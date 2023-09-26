package com.obrs.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.obrs.dto.CustomerDto;
import com.obrs.entity.Customer;
import com.obrs.exception.CustomerNotFoundException;
import com.obrs.service.CustomerService;
import com.obrs.serviceimpl.CustomerServiceImpl;

import java.util.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
  
    @PostMapping("/register")
    @Transactional
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDto customerDto) {
        try {
           customerServiceImpl.registerCustomer(customerDto);
            return new ResponseEntity<>("Customer registered successfully", HttpStatus.CREATED);
        }
        catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("Failed to register customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<String> loginCustomer(
        @PathVariable String username,
        @PathVariable String password
    ) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setUsername(username);
        customerDto.setPassword(password);

        String loginStatus = customerServiceImpl.loginCustomer(username, password);

        if (loginStatus.equals("Login successful")) {
            return new ResponseEntity<>(loginStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(loginStatus, HttpStatus.UNAUTHORIZED);
        }
    }




   

    @GetMapping("/getcustomer/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        
//        if (customerId == null) {
//            return ResponseEntity.badRequest().build();
//        }

        Customer customer = customerServiceImpl.getCustomerById(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(customer);
    }
    @GetMapping("/getallcustomers")
    public List<Customer> getAllCustomers() {
        return customerServiceImpl.findAllCustomers();

}
}

