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
    public ResponseEntity<Product> findById(Long productId) throws Exception {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new Exception ("Product ID: " + productId + " not found"));
        return ResponseEntity.ok().body(product);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean delete(Long id) throws Exception{
        if(!productRepository.existsById(id)){
            throw new Exception("Product ID: " + id + "not found.");
        }else{
            productRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public ResponseEntity<Product> save(Product product) {
        Product prod = productRepository.save(product);

        return ResponseEntity.ok().body(prod);
    }
}
