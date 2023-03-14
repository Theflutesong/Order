package com.balala.Order.service.impl;

import com.balala.Order.entity.OrderDetail;
import com.balala.Order.mapper.OrderDetailMapper;
import com.balala.Order.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
