package com.balala.Order.service.impl;

import com.balala.Order.entity.User;
import com.balala.Order.mapper.UserMapper;
import com.balala.Order.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
