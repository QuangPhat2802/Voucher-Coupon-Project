package com.demo.service;

import java.util.List;

import com.demo.entity.OrdersEntity;

public interface OrdersService {
	
	OrdersEntity addOrders(OrdersEntity donHangEntity);
	
	List<OrdersEntity> getListOrders();

}
	