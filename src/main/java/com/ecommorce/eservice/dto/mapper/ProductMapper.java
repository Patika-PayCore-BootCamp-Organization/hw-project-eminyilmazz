package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.product.ProductDto;
import com.ecommorce.eservice.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductMapper {
    private ProductMapper(){ }

    public static ProductDto toDto(Product product) {
        return new ProductDto(product.getName(),
                product.getPrice());
    }

    public static Product toEntity(ProductDto productDto) {
        return new Product(productDto.getName(), productDto.getPrice());
    }
    public static Map<Long, Integer> productQuantityMapper(){

        return new HashMap<>();
    }
}
