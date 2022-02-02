package com.ecommorce.eservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "product_name")
    @Getter
    private String name;

    @Column(name = "price")
    @Getter
    private float price;

    @Column(name = "image_url", nullable = true)
    @Getter
    private String imageUrl;

    public Product(String name, float price) {
        this.name = name;
        this. price = price;
    }
}
