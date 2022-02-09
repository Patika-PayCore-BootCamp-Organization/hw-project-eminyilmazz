package com.ecommorce.eservice.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", unique = true)
    private String token;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

//    @OneToMany(cascade = CascadeType.ALL,
//               targetEntity = Order.class,
//               fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id",
//                referencedColumnName = "orderId")
//    @JsonBackReference
//    private List<Order> orderHistory;

    public User(String email, String name, String password, String username) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
    }

    @PostConstruct
    public void tokenInit() {
        this.token = UUID.randomUUID().toString();
    }
}
