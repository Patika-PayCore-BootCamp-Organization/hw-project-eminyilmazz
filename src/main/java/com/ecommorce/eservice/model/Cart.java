package com.ecommorce.eservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
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

    @OneToOne(cascade = CascadeType.ALL,
              targetEntity = User.class,
              fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    @Column(name = "product_quantity")
    private Map<Long, Integer> productQuantityMap;
//    @JsonBackReference
//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL,
//               targetEntity = Product.class,
//               fetch = FetchType.LAZY)
//    @JoinColumn(name = "cart_id",
//                referencedColumnName = "id")
//    private List<Product> products;
}