package com.ecommorce.eservice.service;


import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;

public interface UserService {

    UserDto getByUsername(String token);

    String signup(UserDto userDto);

    Iterable<User> getAllUser();
}
