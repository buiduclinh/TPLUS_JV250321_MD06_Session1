package org.example.ex7.controller;

import org.example.ex7.dto.CreateOrderRequest;
import org.example.ex7.model.*;
import org.example.ex7.repo.CustomerRepository;
import org.example.ex7.repo.OrderRepository;
import org.example.ex7.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
