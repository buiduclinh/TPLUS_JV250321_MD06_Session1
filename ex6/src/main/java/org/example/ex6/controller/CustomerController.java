package org.example.ex6.controller;

import org.example.ex6.model.Customer;
import org.example.ex6.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer customer1 =customerRepository.findById(id).orElse(null);
        customer1.setStatus(customer.getStatus());
        return customerRepository.save(customer);
    }
}
