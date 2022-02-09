package com.ecommorce.eservice.dto.cart;

import com.ecommorce.eservice.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDto {
    private Map<ProductDto, Integer> cartProducts;
    private double totalPrice;
}
