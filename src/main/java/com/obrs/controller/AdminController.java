package com.obrs.controller;
import com.obrs.dto.AdminDto;
import com.obrs.entity.Admin;
import com.obrs.exception.AdminNotFoundException;
import com.obrs.exception.CustomerNotFoundException;
import com.obrs.repository.AdminRepository;
import com.obrs.service.AdminService;
import com.obrs.serviceimpl.AdminServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody AdminDto adminDto) {
        try {
                       adminServiceImpl.addAdmin(adminDto);
            return ResponseEntity.ok("Admin added successfully");
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding admin");
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody AdminDto adminDto
    ) {
        try {
            // Create an AdminDto from path variables
//            AdminDto adminDto = new AdminDto();
//            adminDto.setAdminName(adminName);
//            adminDto.setPassword(password);

            Admin admin = adminServiceImpl.loginAdmin(adminDto);
            return ResponseEntity.ok("Login success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error login admin");
        }
    }

}
