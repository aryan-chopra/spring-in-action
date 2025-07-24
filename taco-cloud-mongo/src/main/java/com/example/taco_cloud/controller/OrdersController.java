package com.example.taco_cloud.controller;

import com.example.taco_cloud.domain.Order;
import com.example.taco_cloud.domain.Taco;
import com.example.taco_cloud.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrdersController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/current")
    public String orderForm(
            @SessionAttribute("order") Order order
    ) {
        log.info("Got order: {}", order);

        return "orderForm";
    }

    @PostMapping
    public String processOrder(
            @Valid Order order, Errors errors,
            SessionStatus status
    ) {
        if (errors.hasErrors()) {
            log.info(errors.getAllErrors().toString());
            return "orderForm";
        }

        orderRepository.save(order);
        status.setComplete();

        return "redirect:/";
    }
}
