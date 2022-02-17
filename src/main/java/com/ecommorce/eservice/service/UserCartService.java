package com.ecommorce.eservice.service;

import com.ecommorce.eservice.dto.CartProductDto;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserCartService {
    ResponseEntity<Order> checkout(String username, String address);

    ResponseEntity removeItemFromCart(CartProductDto removableProduct);

    Map<Long, Integer> getCurrentCart(String token);

    Cart addProductToCart(CartProductDto addableProduct);
}
