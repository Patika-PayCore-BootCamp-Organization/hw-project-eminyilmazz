package com.ecommorce.eservice.controller;


import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl customerService;

    @PostMapping("/add")
    public ResponseEntity<User> addCustomer(@RequestBody @Valid UserDto userDto) {
        return customerService.save(userDto);
    }

    @GetMapping("/all")
    public Iterable<User> getAllCustomer() {
        return customerService.getAllUser();
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteCustomer(@RequestParam(name = "id") Long customerId) {
        return customerService.deleteUser(customerId);
    }
//    @GetMapping ("/checkout")
}
