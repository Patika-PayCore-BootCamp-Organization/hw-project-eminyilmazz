package com.ecommorce.eservice.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "current_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private List<Product> products;
}
