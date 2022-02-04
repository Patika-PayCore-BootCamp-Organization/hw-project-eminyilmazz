package com.ecommorce.eservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "user_purchased")
    private Long userPurchased;

    @Column(name = "total_price")
    private float totalPrice;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = Product.class)
    @JoinColumn(name = "product_id",
            referencedColumnName = "productId")
    private List<Product> productList;

    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;

}
