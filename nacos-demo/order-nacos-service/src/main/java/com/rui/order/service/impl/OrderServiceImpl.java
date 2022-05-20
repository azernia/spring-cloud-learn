package com.rui.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.order.mapper.OrderMapper;
import com.rui.order.pojo.Order;
import com.rui.order.pojo.User;
import com.rui.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * create date 2022/5/20 11:28
 *
 * @author rui
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final RestTemplate restTemplate;

    @Autowired
    public OrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Order getOrder(Long id) {
        Order order = getById(id);
        String url = "http://user-nacos-service/user/" + order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }
}
