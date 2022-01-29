package com.ecommorce.eservice.service;

import com.ecommorce.eservice.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id) throws Exception;

    Product update(Product product);

    boolean delete(Product product);

    ResponseEntity<Product> save(Product product);
}
