package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Product;

import java.util.List;

public interface CartService {
    void checkout();

    void removeItem(Integer productId);

    void confirmPayment();

    Cart getCurrentCart(String token);
}
