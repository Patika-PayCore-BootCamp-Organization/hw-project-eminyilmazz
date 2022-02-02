package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.repository.OrderRepository;
import com.ecommorce.eservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
}
