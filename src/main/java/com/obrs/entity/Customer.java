package com.obrs.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 
/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
@Table(name="customer")
public class Customer {
	@Id
	private int customerId;
	@NotNull(message = "First name cannot be blank")
	@Size(max = 50, message = "First name cannot be longer than 50 characters")
	private String firstName;
	@NotNull(message = "Last name cannot be blank")
	@Size(max = 50, message = "Last name cannot be longer than 50 characters")
	private String lastName;
	@Email(message = "Invalid email format")
	private String email;
	@NotNull(message = "Gender cannot be blank")
	private String gender;
	@Positive(message = "Phone number must be a positive number")
	private long phonenumber;
	private String username;
	@NotNull(message = "Password cannot be blank")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	private String password;
	private int age;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Customer(int customerId,
			@NotNull(message = "First name cannot be blank") @Size(max = 50, message = "First name cannot be longer than 50 characters") String firstName,
			@NotNull(message = "Last name cannot be blank") @Size(max = 50, message = "Last name cannot be longer than 50 characters") String lastName,
			@Email(message = "Invalid email format") String email,
			@NotNull(message = "Gender cannot be blank") String gender,
			@Positive(message = "Phone number must be a positive number") long phonenumber, String username,
			@NotNull(message = "Password cannot be blank") @Size(min = 8, message = "Password must be at least 8 characters long") String password,
			int age) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		this.age = age;
	}
	 
	    
    
}

