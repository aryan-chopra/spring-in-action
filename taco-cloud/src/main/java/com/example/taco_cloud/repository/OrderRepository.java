package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.Order;

public interface OrderRepository {

    Order save(Order order);
}
