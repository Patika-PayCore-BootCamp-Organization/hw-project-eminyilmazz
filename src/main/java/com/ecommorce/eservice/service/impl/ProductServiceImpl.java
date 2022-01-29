package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.ProductRepository;
import com.ecommorce.eservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long productId) throws Exception {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception ("Product ID: " + productId + " not found"));
        return product;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public ResponseEntity<Product> save(Product product) {
        return null;
    }
}
