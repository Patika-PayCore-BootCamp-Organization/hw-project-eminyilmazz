package com.ecommorce.eservice.Repository;

import com.ecommorce.eservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
