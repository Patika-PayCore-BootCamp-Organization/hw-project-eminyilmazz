package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.mapper.ProductMapper;
import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.messaging.producer.OrderProducer;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.OrderRepository;
import com.ecommorce.eservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        Map<ProductDto, Integer> productQuantityMap = productQuantityMapper(quantityMap);
        Order order = Order.builder()
                    .totalPrice(totalPrice)
                    .userPurchased(userPurchased)
                    .address(address)
                    .productQuantity(productQuantityMap)
                    .build();
        orderProducer.onOrder(order);
        return order;
    }

    @Override
    public Map<ProductDto, Integer> productQuantityMapper(Map<Long, Integer> quantityMap) {
        Map<ProductDto, Integer> productQuantityMap = Collections.emptyMap();
        quantityMap.entrySet().stream().map(entry ->
            productQuantityMap.put
                    (ProductMapper.toDto(productService.findById(entry.getKey())
                                                        .getBody()), entry.getValue())).close();
        return productQuantityMap;
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