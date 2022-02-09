package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.service.AuthenticationService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserServiceImpl customerService;

    public User getUser(String token) throws IllegalAuthenticationException {
        return customerService.getByToken(token);
    }

    @Override
    public boolean authenticateToken(String token) throws IllegalAuthenticationException {
        if (token.trim().isEmpty()) throw new IllegalAuthenticationException("Given token is null or empty");
        if (this.getUser(token) == null)
            throw new IllegalAuthenticationException("An user does not exist for given token.");
        return true;
    }
}