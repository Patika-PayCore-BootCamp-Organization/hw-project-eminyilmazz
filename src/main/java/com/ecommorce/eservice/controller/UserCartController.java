package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.dto.CartProductDto;
import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.exception.IllegalBodyException;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Order;
import com.ecommorce.eservice.service.impl.AuthenticationServiceImpl;
import com.ecommorce.eservice.service.impl.UserCartServiceImpl;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class UserCartController {
    @Autowired
    private UserCartServiceImpl userCartService;
    @Autowired
    AuthenticationServiceImpl authenticationService;

    @GetMapping("/current")
    public Cart getCurrentCart(@RequestParam(name = "token") String userToken) throws IllegalAuthenticationException {
        authenticationService.authenticateToken(userToken);
        return userCartService.getCurrentCart(userToken);
    }

    @PutMapping("/add-item")
    public Cart addProductToCart(@RequestBody CartProductDto addableProduct){
        authenticationService.authenticateToken(addableProduct.getUserToken());
        if(addableProduct.getAmount() == null) addableProduct.setAmount(1);
        return userCartService.addProductToCart(addableProduct);
    }

    @DeleteMapping("/delete")
    public ResponseEntity removeProductFromCart (@RequestBody CartProductDto removableProduct) throws IllegalAuthenticationException {
        authenticationService.authenticateToken(removableProduct.getUserToken());
        return userCartService.removeItemFromCart(removableProduct);
    }
    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestParam(name = "token") String userToken, @RequestBody ObjectNode objectNode) throws IllegalBodyException {
        authenticationService.authenticateToken(userToken);
        if(!objectNode.has("address")) throw new IllegalBodyException("Address. @PostMapping /cart/checkout.");
        String address = objectNode.get("address").asText("Address is not provided.");
        return userCartService.checkout(userToken, address);
    }
}
