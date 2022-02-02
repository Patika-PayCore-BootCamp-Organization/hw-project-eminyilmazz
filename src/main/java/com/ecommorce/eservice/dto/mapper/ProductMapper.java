package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.model.Product;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        return new ProductDto(product.getName(),
                              product.getPrice());
    }
    public static Product toEntity (ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getPrice());
    }
}
