package org.example.ex4.controller;



import org.example.ex4.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        List<Product> products = List.of(
                new Product(1, "iPhone 15", 1),
                new Product(2, "Samsung Galaxy S24", 1),
                new Product(3, "MacBook Pro", 2),
                new Product(4, "Dell XPS 13", 2),
                new Product(5, "Sony WH-1000XM5", 3)
        );
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}