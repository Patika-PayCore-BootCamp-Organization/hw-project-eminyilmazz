package com.ecommorce.eservice.service;

import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;

import java.util.Map;

public interface OrderService {
    Order fillOrder(Cart cart, String address);

    double calculateTotalPrice(Map<Long, Integer> quantityMap);

    void save(Order order);

    Map<ProductDto, Integer> productQuantityMapper(Map<Long, Integer> quantityMap);
}
