package com.balala.Order.service.impl;

import com.balala.Order.entity.AddressBook;
import com.balala.Order.mapper.AddressBookMapper;
import com.balala.Order.service.AddressBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}
