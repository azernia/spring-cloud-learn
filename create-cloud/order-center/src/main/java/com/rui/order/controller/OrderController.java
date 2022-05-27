package com.rui.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * create date 2022/5/27 14:04
 *
 * @author rui
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/add")
    public String add() {
        String forObject = restTemplate.getForObject("http://localhost:8081/stock/add", String.class);
        return "下单成功 " + forObject;
    }

}
