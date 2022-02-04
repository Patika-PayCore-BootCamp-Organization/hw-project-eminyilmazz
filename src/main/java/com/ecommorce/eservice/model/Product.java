package com.ecommorce.eservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long productId;

    @Column(name = "product_name")
    @Getter
    private String name;

    @Column(name = "price")
    @Getter
    private float price;

    @Column(name = "image_url")
    @Getter
    private String imageUrl;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
