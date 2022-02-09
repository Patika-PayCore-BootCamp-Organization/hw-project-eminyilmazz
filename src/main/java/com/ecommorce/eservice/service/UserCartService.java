package com.ecommorce.eservice.service;

import com.ecommorce.eservice.dto.CartProductDto;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import org.springframework.http.ResponseEntity;

public interface UserCartService {
    ResponseEntity<Order> checkout(String token, String address);

    ResponseEntity removeItemFromCart(CartProductDto removableProduct);

    Cart getCurrentCart(String token);

    Cart addProductToCart(CartProductDto addableProduct);
}
