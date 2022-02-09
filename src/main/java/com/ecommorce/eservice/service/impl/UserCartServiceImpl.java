package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.CartProductDto;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import com.ecommorce.eservice.model.User;
import com.ecommorce.eservice.repository.UserCartRepository;
import com.ecommorce.eservice.service.UserCartService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserCartServiceImpl implements UserCartService {

    @Autowired
    UserCartRepository userCartRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    OrderServiceImpl orderService;

    @Override
    public Cart getCurrentCart(String token) {
        User user = userService.getByToken(token);
        return userCartRepository.findCartByUser_Id(user.getId());
    }

    @Override
    public Cart addProductToCart(@NotNull CartProductDto addableProduct) {
        Cart cart = userCartRepository.findCartByUser_token(addableProduct.getUserToken());
        Long productId = addableProduct.getProductId();
        Integer amountToAdd = addableProduct.getAmount();
        Map<Long, Integer> cartMap = cart.getProductQuantityMap();
        if(cartMap.containsKey(productId)) {
            Integer existingAmount = cartMap.get(productId);
            cartMap.replace(productId, amountToAdd + existingAmount);
        } else {
            cartMap.put(productId, amountToAdd);
        }
        cart.setProductQuantityMap(cartMap);
        return userCartRepository.save(cart);
    }

    @Override
    public ResponseEntity<Order> checkout(String token, String address) {
        Cart cart = userCartRepository.findCartByUser_token(token);
        Order order = orderService.fillOrder(cart, address);
        orderService.save(order);
        userCartRepository.delete(cart);
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<String> removeItemFromCart(@NotNull CartProductDto removableProduct) {
        Cart cart = userCartRepository.findCartByUser_token(removableProduct.getUserToken());
        Map<Long, Integer> cartMap = cart.getProductQuantityMap();
        Long productId = removableProduct.getProductId();
        if(!cartMap.containsKey(productId)) return ResponseEntity.notFound().build();

        else cartMap.remove(productId);

        cart.setProductQuantityMap(cartMap);
        userCartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Product is removed from your cart");
    }
}