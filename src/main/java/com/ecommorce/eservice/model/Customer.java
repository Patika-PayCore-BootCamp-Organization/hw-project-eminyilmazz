package com.ecommorce.eservice.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@NoArgsConstructor
@Entity
@Getter
@Table(name = "customer_info")
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "token")
    private String token;

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

    public Customer(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.token = UUID.randomUUID().toString();

    }
}
