package com.ecommorce.eservice.service.impl;

import com.ecommorce.eservice.dto.customer.CustomerDto;
import com.ecommorce.eservice.dto.mapper.CustomerMapper;
import com.ecommorce.eservice.model.Customer;
import com.ecommorce.eservice.repository.CustomerRepository;
import com.ecommorce.eservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getByToken(String token) {
        Customer customer = customerRepository.getByToken(token).orElse(null);
        return customer;
    }

    public ResponseEntity<Customer> save(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        return ResponseEntity.ok()
                .body(customerRepository.save(customer));
    }

    public Iterable<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public ResponseEntity deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Product ID: " + " is deleted.");
        }
    }

}
