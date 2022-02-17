package com.ecommorce.eservice.service;

import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ResponseEntity<Product> findById(Long id) throws Exception;

    ResponseEntity<Product> update(Product product) throws Exception;

    ResponseEntity delete(Long id) throws Exception;

    ResponseEntity<Product> save(Product product);

    List<Product> findAllAsProduct();
}
