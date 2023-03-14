package com.balala.Order.service.impl;

import com.balala.Order.entity.ShoppingCart;
import com.balala.Order.mapper.ShoppingCartMapping;
import com.balala.Order.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapping, ShoppingCart> implements ShoppingCartService {
}
