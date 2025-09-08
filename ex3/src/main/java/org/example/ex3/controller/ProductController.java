package org.example.ex3.controller;


import org.example.ex3.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/by-category/{categoryId}")
    public List<Product> getProductsByCategory(@RequestParam int categoryId) {

        List<Product> products = List.of(
                new Product(1, "iPhone 15", 1),
                new Product(2, "Samsung Galaxy S24", 1),
                new Product(3, "MacBook Pro", 2),
                new Product(4, "Dell XPS 13", 2),
                new Product(5, "Sony WH-1000XM5", 3)
        );

        return products.stream()
                .filter(p -> p.getCategoryId() == categoryId)
                .collect(Collectors.toList());
    }
}
