package com.rui.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rui.order.pojo.Order;

public interface OrderService extends IService<Order> {

    Order getOrder(Long id);

}
