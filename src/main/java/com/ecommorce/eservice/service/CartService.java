package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Product;

import java.util.List;

public interface CartService {
    void checkout();
    void removeItem(Product product);
    void confirmPayment();
    List<Cart> getCurrentCart();
}
