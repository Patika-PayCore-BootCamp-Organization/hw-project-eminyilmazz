package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.dto.mapper.UserMapper;
import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.exception.NotFoundException;
import com.ecommorce.eservice.model.User;
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

    public UserDto getByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent()) throw new NotFoundException("User: " + username + " not found.");
        else return UserMapper.toDto(userRepository.findByUsername(username).get());
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public String signup(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        if(!userRepository.existsByUsername(userDto.getUsername())) {
            Map<User, String> singletonMap = userSecurityService.signupEncoding(user);
            userRepository.save(singletonMap.keySet().stream().findFirst().get());
            return singletonMap.values().toString();
        }
        else throw new IllegalAuthenticationException("Username already exists.", HttpStatus.BAD_REQUEST);
    }

    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    public ResponseEntity deleteUser(String username) {
        if (!userRepository.existsByUsername(username)) {
            return ResponseEntity.notFound().build();
        } else {
            userRepository.deleteByUsername(username);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Username: " + username + " is deleted.");
        }
    }
}
