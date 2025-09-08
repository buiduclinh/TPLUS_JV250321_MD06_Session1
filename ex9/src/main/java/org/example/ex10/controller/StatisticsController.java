package org.example.ex10.controller;

import org.example.ex10.dto.CustomerOrderStatisticsDTO;
import org.example.ex10.model.Order;
import org.example.ex10.model.OrderStatus;
import org.example.ex10.repo.CustomerRepository;
import org.example.ex10.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @GetMapping("/revenue-this-month")
    public ResponseEntity<Double> getRevenueThisMonth() {
        LocalDate now = LocalDate.now();
        LocalDateTime startOfMonth = now.withDayOfMonth(1).atStartOfDay();
        LocalDateTime startOfNextMonth = now.plusMonths(1).withDayOfMonth(1).atStartOfDay();

        List<Order> completedOrders = orderRepository.findByStatusAndOrderDateBetween(
                OrderStatus.COMPLETED,
                startOfMonth,
                startOfNextMonth
        );

        double revenue = completedOrders.stream()
                .flatMap(order -> order.getDetails().stream())
                .mapToDouble(detail -> detail.getQuantity() * detail.getPrice())
                .sum();

        return ResponseEntity.ok(revenue);
    }

    @GetMapping("/orders-statistics")
    public List<CustomerOrderStatisticsDTO> getOrdersStatistics() {
        return customerRepository.getCustomerOrderStatistics();
    }
}