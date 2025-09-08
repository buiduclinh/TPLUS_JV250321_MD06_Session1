package org.example.ex8.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequest {
    private Long customerId;
    private List<OrderDetailRequest> details;
    private Long productId;
    @Data
    public static class OrderDetailRequest {
        private String productName;
        private int quantity;
        private double price;
    }
}
