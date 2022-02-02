package com.ecommorce.eservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;


@NoArgsConstructor
@Entity
@Getter
@Table(name = "customer_info")
public class Customer{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "email")
    @Email
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;


//    @Column
//    private List<Order> orderHistory;


//    @Column
//    private Cart userCart;
}
