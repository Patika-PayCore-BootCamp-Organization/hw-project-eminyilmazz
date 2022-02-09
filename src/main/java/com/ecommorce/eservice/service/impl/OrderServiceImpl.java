package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.messaging.producer.OrderProducer;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.OrderRepository;
import com.ecommorce.eservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    OrderProducer orderProducer;

    @Override
    public Order fillOrder(Cart cart, String address) {
        Map<Long, Integer> quantityMap = cart.getProductQuantityMap();
        double totalPrice = calculateTotalPrice(quantityMap);
        String userPurchased = cart.getUser().getUsername();
        Order order = Order.builder()
                    .totalPrice(totalPrice)
                    .userPurchased(userPurchased)
                    .billingAddress(address)
                    .build();
        orderProducer.onOrder(order);
        return order;
    }

    @Override
    public double calculateTotalPrice(Map<Long, Integer> quantityMap) {
        List<Product> productList = productService.findAllAsProduct();
        return productList.stream().filter(p -> quantityMap.containsKey(p.getId()))
                            .map(product ->
                                    product.getPrice() * quantityMap.get(product.getId()))
                            .reduce(0D, Double::sum);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}