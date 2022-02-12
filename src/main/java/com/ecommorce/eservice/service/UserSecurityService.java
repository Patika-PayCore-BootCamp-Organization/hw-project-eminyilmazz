package com.ecommorce.eservice.service;

import com.ecommorce.eservice.dto.user.UserLoginDto;
import com.ecommorce.eservice.model.User;

import java.util.Map;

public interface UserSecurityService {
    String signin(UserLoginDto userLoginDto);

    Map<User, String> signupEncoding(User user);
}
