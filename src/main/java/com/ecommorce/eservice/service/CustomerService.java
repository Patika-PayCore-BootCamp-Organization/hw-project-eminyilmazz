package com.ecommorce.eservice.service;


import com.ecommorce.eservice.dto.customer.CustomerDto;
import com.ecommorce.eservice.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {

    Customer getByToken(String token);

    ResponseEntity<Customer> save(CustomerDto customerDto);

    Iterable<Customer> getAllCustomer();

}
