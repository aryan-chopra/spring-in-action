package com.example.taco_cloud.controller;

import com.example.taco_cloud.service.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private OrderAdminService adminService;

    @GetMapping
    public String admin() {
        return "admin";
    }

    @PostMapping("/deleteAll")
    public String deleteAll() {
        adminService.deleteAllOrders();
        return "redirect:/admin";
    }
}
