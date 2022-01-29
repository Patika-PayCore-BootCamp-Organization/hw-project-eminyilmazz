package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.service.ProductService;
import com.ecommorce.eservice.service.impl.ProductServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
    public @NotNull List<Product> getProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable(value = "id") Long productId) throws Exception {
        return productService.findById(productId);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable (value = "id") Long productId) throws Exception {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }
}
