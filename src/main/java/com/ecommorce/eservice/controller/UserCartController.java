package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.dto.CartProductDto;
import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.exception.IllegalBodyException;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import com.ecommorce.eservice.service.UserCartService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/cart")
public class UserCartController {
    @Autowired
    private UserCartService userCartService;

    @GetMapping("/current")
    public Map<Long, Integer> getCurrentCart(@RequestParam(name = "username") String username) {
        return userCartService.getCurrentCart(username);
    }

    @PutMapping("/add-item")
    public Cart addProductToCart(@RequestBody CartProductDto addableProduct) {
        if (addableProduct.getAmount() == null) addableProduct.setAmount(1);
        return userCartService.addProductToCart(addableProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity removeProductFromCart(@RequestBody CartProductDto removableProduct) throws IllegalAuthenticationException {
        return userCartService.removeItemFromCart(removableProduct);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestParam(name = "username") String username, @RequestBody ObjectNode objectNode) throws IllegalBodyException {
        if (!objectNode.has("address")) throw new IllegalBodyException("Address. @PostMapping /cart/checkout.");
        String address = objectNode.get("address").asText("Address is not provided.");
        return userCartService.checkout(username, address);
    }
}
