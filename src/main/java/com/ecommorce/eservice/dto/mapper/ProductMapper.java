package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.model.Product;

public class ProductMapper {
    private ProductMapper() {
    }

    public static ProductDto toDto(Product product) {
        return new ProductDto(product.getName(),
                product.getPrice());
    }
}
