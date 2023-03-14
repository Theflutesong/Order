package com.balala.Order.dto;


import com.balala.Order.entity.OrderDetail;
import com.balala.Order.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
	
}
