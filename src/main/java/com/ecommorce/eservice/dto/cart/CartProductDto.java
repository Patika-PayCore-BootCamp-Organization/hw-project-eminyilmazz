package com.ecommorce.eservice.dto.cart;

import com.ecommorce.eservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartProductDto {
    private Long id;
    private Integer quantity;
    private Product product;
}
