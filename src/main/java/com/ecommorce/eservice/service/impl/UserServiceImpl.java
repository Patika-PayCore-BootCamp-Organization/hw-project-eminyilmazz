package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.dto.mapper.UserMapper;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.repository.UserRepository;
import com.ecommorce.eservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User getByToken(String token) {
        User user = userRepository.findByToken(token).orElse(null);
        return user;
    }

    public ResponseEntity<User> save(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        return ResponseEntity.ok()
                .body(userRepository.save(user));
    }


    public Iterable<User> getAllUser() {
        return userRepository.findAll();
    }

    public ResponseEntity deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Product ID: " + " is deleted.");
        }
    }

}
