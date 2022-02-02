package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Customer;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.CartRepository;
import com.ecommorce.eservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart getCurrentCart(String token) {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        Customer customer = customerService.getByToken(token);

        //TODO: Convert to product list.
        return new Cart();
    }

    @Override
    public void checkout() {

    }

    @Override
    public void removeItem(Integer productId) {
    }

    @Override
    public void confirmPayment() {
        //TODO: RabbitMQ message to process payment.
    }

}
