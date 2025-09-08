package org.example.ex10.repo;

import org.example.ex10.dto.CustomerOrderStatisticsDTO;
import org.example.ex10.model.Order;
import org.example.ex10.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByStatusAndOrderDateBetween(OrderStatus status,
                                                LocalDateTime start,
                                                LocalDateTime end);
    @Query("SELECT new org.example.ex10.dto.CustomerOrderStatisticsDTO(c.id, c.fullname, c.email, COUNT(o)) " +
            "FROM Customer c LEFT JOIN c.orders o " +
            "GROUP BY c.id, c.fullname, c.email")
    List<CustomerOrderStatisticsDTO> getCustomerOrderStatistics();
}
