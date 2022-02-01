package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.CartRepository;
import com.ecommorce.eservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getCurrentCart() {
        //TODO: Convert to product list.
        return cartRepository.findAll();
    }

    @Override
    public void checkout() {

    }

    @Override
    public void removeItem(Product product) {

    }

    @Override
    public void confirmPayment() {
        //TODO: RabbitMQ message to process payment.
    }

}
