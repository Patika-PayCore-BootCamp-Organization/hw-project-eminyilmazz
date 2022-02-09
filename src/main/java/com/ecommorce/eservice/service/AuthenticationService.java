package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.User;

public interface AuthenticationService {
    boolean authenticateToken(String token);

    public User getUser(String token);
}
