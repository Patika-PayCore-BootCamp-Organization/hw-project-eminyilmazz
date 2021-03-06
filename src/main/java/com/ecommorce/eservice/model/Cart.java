package com.ecommorce.eservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @MapsId
    private User user;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "product_quantity")
    private Map<Long, Integer> productQuantityMap;

    public Cart(User user) {
        this.user = user;
        this.productQuantityMap = Collections.emptyMap();
    }
}