package org.example.ex8.controller;

import org.example.ex8.dto.CreateOrderRequest;
import org.example.ex8.model.*;
import org.example.ex8.repo.CustomerRepository;
import org.example.ex8.repo.OrderRepository;
import org.example.ex8.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Order createOrder (@RequestBody CreateOrderRequest request){
        Customer customer = customerRepository.findById(request.getCustomerId()).orElse(null);
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus(OrderStatus.PENDING);

        OrderDetail detail = new OrderDetail();
        detail.setProductName(product.getName());
        detail.getPrice();
        detail.getQuantity();
        detail.getOrder();

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(detail);
        order.setDetails(orderDetails);

        return orderRepository.save(order);
    }

    @PutMapping("/{orderId}/confirm")
    public ResponseEntity<Order> confirmOrder(@PathVariable Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        if (order.getStatus() == OrderStatus.COMPLETED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(order);
        }

        order.setStatus(OrderStatus.COMPLETED);
        Order saved = orderRepository.save(order);

        return ResponseEntity.ok(saved);
    }
}

