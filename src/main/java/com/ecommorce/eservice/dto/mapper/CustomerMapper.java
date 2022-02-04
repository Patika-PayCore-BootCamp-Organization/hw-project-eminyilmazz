package com.ecommorce.eservice.dto.mapper;

import com.ecommorce.eservice.dto.customer.CustomerDto;
import com.ecommorce.eservice.model.Customer;

import javax.validation.constraints.NotNull;

public class CustomerMapper {

    public static CustomerDto toDto(@NotNull Customer customer) {
        CustomerDto customerDto = new CustomerDto(customer.getName(),
                customer.getEmail(),
                customer.getPassword());
        return customerDto;
    }

    public static Customer toEntity(@NotNull CustomerDto customerDto) {
        return new Customer(customerDto.getEmail(),
                customerDto.getName(),
                customerDto.getPassword());
    }
}
