package com.ecommorce.eservice.service;


import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User getByToken(String token);

    ResponseEntity<User> save(UserDto userDto);

    Iterable<User> getAllUser();

}
