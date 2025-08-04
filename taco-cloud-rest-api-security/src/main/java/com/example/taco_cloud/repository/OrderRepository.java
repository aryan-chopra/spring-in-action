package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
