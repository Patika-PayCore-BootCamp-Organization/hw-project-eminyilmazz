package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.repository.CustomerRepository;
import com.ecommorce.eservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
}
