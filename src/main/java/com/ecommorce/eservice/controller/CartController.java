package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.model.Cart;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @GetMapping("/current")
    public Cart getCurrentCart () {return cartService.getCurrentCart();}

    @DeleteMapping("/delete")
    public void deleteProduct (@RequestParam(name = "product-id") Integer productId)
    {
        cartService.removeItem(productId);
    }



}
