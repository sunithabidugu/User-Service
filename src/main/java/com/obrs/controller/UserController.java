package com.obrs.controller;
import com.obrs.dto.UserDto;
import com.obrs.entity.User;
import com.obrs.exception.UserNotFoundException;
import com.obrs.service.UserService;
import com.obrs.serviceimpl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDto) {
        User user = userServiceImpl.registerUser(userDto);
        
        
        
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDto userDto) {

            User user = userServiceImpl.loginUser(userDto);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

  

