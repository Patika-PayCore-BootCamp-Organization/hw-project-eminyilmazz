package com.ecommorce.eservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
    private double price;

    @Column(name = "image_url")
    @Getter
    private String imageUrl;

    public Product(String name, @NotNull double price) {
        this.name = name;
        this.price = price;
    }
}
