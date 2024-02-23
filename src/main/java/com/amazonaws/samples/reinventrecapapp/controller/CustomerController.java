package com.amazonaws.samples.reinventrecapapp.controller;


import com.amazonaws.samples.reinventrecapapp.model.Customer;
import com.amazonaws.samples.reinventrecapapp.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerController {

    final CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable Long customerId) {
        return customerRepository.findById(customerId);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
}
