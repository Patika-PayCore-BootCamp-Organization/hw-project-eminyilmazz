package com.ecommorce.eservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CartProductDto {
    private String userToken;
    private Long productId;
    private Integer amount;
}
