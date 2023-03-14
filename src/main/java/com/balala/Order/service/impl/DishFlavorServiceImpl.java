package com.balala.Order.service.impl;


import com.balala.Order.dto.DishDto;
import com.balala.Order.entity.DishFlavor;
import com.balala.Order.mapper.DishFlavorMapper;
import com.balala.Order.service.DishFlavorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {

}
