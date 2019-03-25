package com.fges.rizomm.m1.bakery.controller;

import com.fges.rizomm.m1.bakery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

}
