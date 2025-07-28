package com.example.taco_cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String testGet() {
        return "test";
    }

    @GetMapping("secure-test")
    public String secureTestGet() {
        return "test";
    }
}
