package org.example.ex5.controller;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.example.ex5.model.Customer;
import org.example.ex5.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping
    public List<Customer> getCustomerRepository() {
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable("id") Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
        Customer customer1 = customerRepository.findById(id).orElseThrow();
        return customerRepository.save(customer1);
    }
    @DeleteMapping
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
