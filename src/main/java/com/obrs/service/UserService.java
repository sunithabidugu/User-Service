package com.obrs.service;

import com.obrs.dto.UserDto;
import com.obrs.entity.User;
import com.obrs.exception.UserNotFoundException;

public interface UserService {
    User registerUser(UserDto userDto);
    User loginUser(UserDto userDto) throws UserNotFoundException;
    }
