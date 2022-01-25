package com.ecommorce.eservice.Controller;

import com.ecommorce.eservice.Model.Product;
import com.ecommorce.eservice.Repository.ProductRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping()
    public @NotNull List<Product> getProducts() {
        return productRepository.findAll();
    }
}
