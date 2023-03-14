package com.balala.Order.service;

import com.balala.Order.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);
}
