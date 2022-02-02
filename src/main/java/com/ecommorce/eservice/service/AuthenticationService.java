package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.Customer;

public interface AuthenticationService {
    boolean authenticateToken(String token);
    public Customer getUser(String token);
}
