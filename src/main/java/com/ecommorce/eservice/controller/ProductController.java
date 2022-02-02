package com.ecommorce.eservice.controller;

import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/all")
    public List<Product> getProducts() {
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
    @PutMapping ("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception {
        return productService.update(product);
    }
}
