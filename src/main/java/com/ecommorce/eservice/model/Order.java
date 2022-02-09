package com.ecommorce.eservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "user_purchased")
    private String userPurchased;

    @Column(name = "total_price")
    private double totalPrice;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER,
//            targetEntity = Product.class)
//    @JoinColumn(name = "product_id",
//            referencedColumnName = "productId")
//    @JsonManagedReference
//    private List<Product> productList;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;

}