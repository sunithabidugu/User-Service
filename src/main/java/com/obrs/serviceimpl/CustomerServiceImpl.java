package com.obrs.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.obrs.dto.CustomerDto;
import com.obrs.entity.Customer;
import com.obrs.exception.CustomerNotFoundException;
import com.obrs.repository.CustomerRepository;
import com.obrs.service.CustomerService;

import java.util.List;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setGender(customerDto.getGender());
        customer.setPhonenumber(customerDto.getPhonenumber());
        customer.setAge(customerDto.getAge());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customerRepository.save(customer);
        
        return customer;
    }

   
    @Override
    public Customer getCustomerById(int customerId) {
        java.util.Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (customerOptional.isPresent()) {
            return customerOptional.get(); // Return the customer if found
        } else {
            throw new CustomerNotFoundException("Customer not found with ID: " + customerId);
        }
    }
    
    @Override
        public List<Customer> findAllCustomers() {
            return customerRepository.findAll();

        
    }


	@Override
	public String loginCustomer(String username, String password) {
		Customer customer = customerRepository.findByUsername(username);

	    if (customer == null || !customer.getPassword().equals(password)) {
	        return "Invalid login credentials";
	    }

	    return "Login successful";
	}
	}


   





	

 
