package com.ecommorce.eservice.service;


import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    UserDto getByUsername(String token);

    User getUserByUsername(String username);

    String signup(UserDto userDto);

    Iterable<User> getAllUser();

    ResponseEntity deleteUser(String username);
}
