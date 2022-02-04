package com.ecommorce.eservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "current_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long cartId;

    @OneToOne(cascade = CascadeType.ALL,
            targetEntity = Customer.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",
            referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL,
            targetEntity = Product.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id",
            referencedColumnName = "productId")
    private List<Product> products;
}