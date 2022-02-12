package com.ecommorce.eservice.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDto implements Serializable {
    private String username;
    private String password;
}
