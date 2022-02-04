package com.ecommorce.eservice.controller;


import com.ecommorce.eservice.dto.customer.CustomerDto;
import com.ecommorce.eservice.model.Customer;
import com.ecommorce.eservice.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid CustomerDto customerDto) {
        return customerService.save(customerDto);
    }

    @GetMapping("/all")
    public Iterable<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteCustomer(@RequestParam(name = "id") Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
//    @GetMapping ("/checkout")
}
