package com.rui.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rui.feign.clients.UserClient;
import com.rui.order.mapper.OrderMapper;
import com.rui.order.pojo.Order;
import com.rui.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create date 2022/5/20 11:28
 *
 * @author rui
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private final UserClient userClient;

    @Autowired
    public OrderServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public Order getOrder(Long id) {
        Order order = getById(id);
        order.setUser(userClient.findById(order.getUserId()));
        return order;
    }
}
