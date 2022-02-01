package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {
    @GetMapping("/current")
    public List<Product> getCurrentCart () {return null;}

}
