package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.exception.IllegalAuthenticationException;
import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.service.impl.AuthenticationServiceImpl;
import com.ecommorce.eservice.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


//    @DeleteMapping("/delete")
//    public void removeProductFromCart (@RequestParam(name = "product-id") Integer productId, @RequestBody)
//    {
//        cartService.removeItem(productId);
//    }


}
