package org.example.ex10.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerOrderStatisticsDTO {
    private Long id;
    private String fullname;
    private String email;
    private Long totalOrders;

    public CustomerOrderStatisticsDTO(Long id, String fullname, String email, Long totalOrders) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.totalOrders = totalOrders;
    }
}