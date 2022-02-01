package com.ecommorce.eservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "order")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_purchased")
    private Long userPurchased;
    @Column(name = "total_price")
    private float totalPrice;
//    private List<Product> productList;
    @Column(name = "billing_address")
    private String billingAddress;

    @Column(name = "order_date")
    @CreationTimestamp
    private LocalDateTime orderDate;

}
