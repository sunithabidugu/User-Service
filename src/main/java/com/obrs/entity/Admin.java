package com.obrs.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.persistence.*;

 

@Entity
public class Admin {
	@Id
	@NotNull(message = "Admin ID cannot be null")
    @Positive(message = "Admin ID must be a positive number")
	Long adminId;
	@NotNull(message = "Admin name cannot be null")
    @Size(min = 2, max = 50, message = "Admin name must be between 2 and 50 characters")
	String adminName;
	@NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be at least 8 characters long")
	String password;
	public Admin() {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	}
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
		public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}