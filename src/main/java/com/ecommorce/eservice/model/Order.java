package com.ecommorce.eservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "user_purchased")
    private String userPurchased;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "billing_address")
    private String address;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;

}