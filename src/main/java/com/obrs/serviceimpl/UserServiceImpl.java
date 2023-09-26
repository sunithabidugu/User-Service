package com.obrs.serviceimpl;

import com.obrs.dto.UserDto;
import com.obrs.entity.User;
import com.obrs.exception.UserNotFoundException;
import com.obrs.repository.UserRepository;
import com.obrs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDto userDto) {
        
//        if (userRepository.findByUsername(userDto.getUsername()) != null) {
//                   }

        User newUser = new User();
        newUser.setId(userDto.getId());
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        newUser.setRole(userDto.getRole());
        
        return userRepository.save(newUser);
    }

    @Override
    public User loginUser(UserDto userDto) throws UserNotFoundException {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null || !user.getPassword().equals(userDto.getPassword())) {
            throw new UserNotFoundException("Invalid user credentials");
        }
        return user;
    }
    }
