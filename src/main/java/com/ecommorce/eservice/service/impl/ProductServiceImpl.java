package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.mapper.ProductMapper;
import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.exception.NotFoundException;
import com.ecommorce.eservice.model.Product;
import com.ecommorce.eservice.repository.ProductRepository;
import com.ecommorce.eservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDto> findAll() {
        List<ProductDto> productDtos = productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
        return productDtos;
    }

    @Override
    public ResponseEntity<Product> findById(Long productId) throws NotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product ID: " + productId + " not found"));
        return ResponseEntity.ok().body(product);
    }

    @Override
    public ResponseEntity<Product> update(Product product) throws NotFoundException {
        if (!productRepository.existsById(product.getProductId())) {
            throw new NotFoundException
                    ("@DeleteMapping Product ID = " + product.getProductId() + " is not found.\n");
        } else {
            productRepository.save(product);
            return ResponseEntity.ok().body(product);
        }
    }

    @Override
    public ResponseEntity delete(Long id) throws NotFoundException {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException
                    ("@DeleteMapping Product ID = " + id + " is not found.\n");
        } else {
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product ID: " + " is deleted.");

        }
    }

    @Override
    public ResponseEntity<Product> save(Product product) {
        Product prod = productRepository.save(product);
        return ResponseEntity.ok().body(prod);
    }
}
