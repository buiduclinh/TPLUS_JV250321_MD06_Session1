package org.example.ex10.repo;

import org.example.ex10.dto.CustomerOrderStatisticsDTO;
import org.example.ex10.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    List<CustomerOrderStatisticsDTO> getCustomerOrderStatistics();
}
