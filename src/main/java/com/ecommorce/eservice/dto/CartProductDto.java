package com.ecommorce.eservice.dto;

import lombok.Data;

@Data
public class CartProductDto {
    private String username;
    private Long productId;
    private Integer amount;
}
