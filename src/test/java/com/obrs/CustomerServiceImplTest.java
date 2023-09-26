package com.obrs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.obrs.dto.CustomerDto;
import com.obrs.dto.AdminDto;

import com.obrs.entity.Customer;
import com.obrs.entity.Admin;

import com.obrs.exception.CustomerNotFoundException;
import com.obrs.repository.AdminRepository;
import com.obrs.repository.CustomerRepository;
import com.obrs.serviceimpl.AdminServiceImpl;
import com.obrs.serviceimpl.CustomerServiceImpl;

public class CustomerServiceImplTest {

	@InjectMocks
	private CustomerServiceImpl customerService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private AdminRepository adminRepository;

	@InjectMocks
	private AdminServiceImpl adminService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	/*
	 * @Test public void testRegisterCustomer() { CustomerDto customerDto = new
	 * CustomerDto( Initialize with relevant data ); Customer expectedCustomer = new
	 * Customer( Initialize with relevant data );
	 * when(customerRepository.save(any(Customer.class))).thenReturn(
	 * expectedCustomer);
	 * 
	 * Customer registeredCustomer = customerService.registerCustomer(customerDto);
	 * 
	 * assertNotNull(registeredCustomer); assertEquals(expectedCustomer,
	 * registeredCustomer); verify(customerRepository,
	 * times(1)).save(any(Customer.class)); }
	 */

//    @Test
//    public String testLoginCustomer() {
//        CustomerDto customerDto = new CustomerDto(
////            1L, // Customer ID
////            "FeMale", // Gender
////            30, // Age
////            "vignatha@gmail.com", // Email
////            8978654567L, // Phone number
////            "vignatha", // First Name
////            "nossam", // Last Name
//            "vignathanvr", // Username
//            "password123" // Password
//        );
//
//        Customer expectedCustomer = new Customer();
////        expectedCustomer.setCustomerId(1L);
////        expectedCustomer.setGender("Male");
////        expectedCustomer.setAge(30);
////        expectedCustomer.setEmail("example@email.com");
////        expectedCustomer.setPhonenumber(1234567890L);
////        expectedCustomer.setFirstName("John");
////        expectedCustomer.setLastName("Doe");
//        expectedCustomer.setUsername("johndoe");
//        expectedCustomer.setPassword("password123");
//
//        when(customerRepository.findByUsername(customerDto.getUsername())).thenReturn(expectedCustomer);
//
//        Customer loggedInCustomer = customerService.loginCustomer(customerDto);
//
//        assertNotNull(loggedInCustomer);
//        assertEquals(expectedCustomer, loggedInCustomer);
//    }

//    @Test
//    public void testLoginCustomerInvalidCredentials() {
//        CustomerDto customerDto = new CustomerDto(/* Initialize with relevant data */);
//        when(customerRepository.findByUsername(customerDto.getUsername())).thenReturn(null);
//
//        assertThrows(CustomerNotFoundException.class, () -> customerService.loginCustomer(customerDto));
//    }

	@Test
	public void testGetCustomerById() {
		int customerId = 1;
		Customer expectedCustomer = new Customer(/* Initialize with relevant data */);
		when(customerRepository.findById(customerId)).thenReturn(Optional.of(expectedCustomer));

		Customer retrievedCustomer = customerService.getCustomerById(customerId);

		assertNotNull(retrievedCustomer);
		assertEquals(expectedCustomer, retrievedCustomer);
	}

	@Test
	public void testGetCustomerByIdNotFound() {
		int customerId = 1;
		when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

		assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(customerId));
	}

	@Test
	public void testFindAllCustomers() {
		List<Customer> expectedCustomers = new ArrayList<>();
		// Add expected Customer objects to the list
		when(customerRepository.findAll()).thenReturn(expectedCustomers);

		List<Customer> customers = customerService.findAllCustomers();

		assertNotNull(customers);
		assertEquals(expectedCustomers, customers);
	}

	@Test
	public void testAddAdmin() {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdminId(1L);
		adminDto.setAdminName("adminUser");
		adminDto.setPassword("adminPass");

		Admin savedAdmin = new Admin();
		savedAdmin.setAdminId(1L);
		savedAdmin.setAdminName("adminUser");
		savedAdmin.setPassword("adminPass");

		when(adminRepository.save(any(Admin.class))).thenReturn(savedAdmin);

		Admin addedAdmin = adminService.addAdmin(adminDto);

		assertNotNull(addedAdmin);
		assertEquals(1L, addedAdmin.getAdminId());
		assertEquals("adminUser", addedAdmin.getAdminName());
		assertEquals("adminPass", addedAdmin.getPassword());

		verify(adminRepository, times(1)).save(any(Admin.class));
	}

	@Test
	public void testLoginAdminValidCredentials() {
		AdminDto adminDto = new AdminDto();
		adminDto.setAdminName("adminUser");
		adminDto.setPassword("adminPass");

		Admin existingAdmin = new Admin();
		existingAdmin.setAdminName("adminUser");
		existingAdmin.setPassword("adminPass");

		when(adminRepository.findByAdminName("adminUser")).thenReturn(existingAdmin);

		Admin loggedInAdmin = adminService.loginAdmin(adminDto);

		assertNotNull(loggedInAdmin);
		assertEquals("adminUser", loggedInAdmin.getAdminName());
		assertEquals("adminPass", loggedInAdmin.getPassword());
	}

}
