package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.dto.mapper.UserMapper;
import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.exception.NotFoundException;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.repository.UserCartRepository;
import com.ecommorce.eservice.repository.UserRepository;
import com.ecommorce.eservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserSecurityServiceImpl userSecurityService;
    @Autowired
    UserCartRepository userCartRepository;

    @Override
    public UserDto getByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent()) throw new NotFoundException("User: " + username + " not found.");
        else return UserMapper.toDto(userRepository.findByUsername(username).get());
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public String signup(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        if(!userRepository.existsByUsername(userDto.getUsername())) {
            Map<User, String> singletonMap = userSecurityService.signupEncoding(user);
            user = userRepository.save(singletonMap.keySet().stream().findFirst().get());
            userCartRepository.save(new Cart(user));
            return singletonMap.values().toString();
        }
        else throw new IllegalAuthenticationException("Username already exists.", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public ResponseEntity deleteUser(String username) {
        if (!userRepository.existsByUsername(username)) {
            return ResponseEntity.notFound().build();
        } else {
            userRepository.deleteByUsername(username);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Username: " + username + " is deleted.");
        }
    }
}
