package com.example.taco_cloud.repository;

import com.example.taco_cloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    //Spring Data automatically generates this function according to name
    List<Order> findByDeliveryZip(String deliveryZip);

    /*
     * To write a complex method, annotate it with "@Query"
     * Mention the Query in the @Query method
     */
}
