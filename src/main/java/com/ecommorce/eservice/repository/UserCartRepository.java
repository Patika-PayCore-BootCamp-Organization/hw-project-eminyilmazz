package com.ecommorce.eservice.repository;

import com.ecommorce.eservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByUser_Id(Long id);
    Cart findCartByUser_Username(String username);
}
