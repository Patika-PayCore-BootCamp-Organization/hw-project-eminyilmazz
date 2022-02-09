package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;

import java.util.Map;

public interface OrderService {
    Order fillOrder(Cart cart, String address);

    double calculateTotalPrice(Map<Long, Integer> quantityMap);

    public void save(Order order);
}
