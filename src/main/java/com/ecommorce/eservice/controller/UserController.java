package com.ecommorce.eservice.controller;


import com.ecommorce.eservice.dto.user.UserDto;
import com.ecommorce.eservice.dto.user.UserLoginDto;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.service.UserSecurityService;
import com.ecommorce.eservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserSecurityService userSecurityService;


    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/search")
    public UserDto getByUsername(@RequestParam(name = "username") String username) {
        return userService.getByUsername(username);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@RequestParam(name = "username") String username) {
        return userService.deleteUser(username);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody UserLoginDto userLoginDto) {
        return userSecurityService.signin(userLoginDto);
    }
}
