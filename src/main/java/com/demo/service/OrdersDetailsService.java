package com.demo.service;

import java.util.List;

import com.demo.entity.OrdersDetailsEntity;

public interface OrdersDetailsService {

	OrdersDetailsEntity addPhone(OrdersDetailsEntity ordersDetailsEntity);

	List<OrdersDetailsEntity> getListPhoneAndVoucher();

	List<OrdersDetailsEntity> getListVoucherCodeByPhone(int phone);

	List<OrdersDetailsEntity> getListVoucherByPhoneAndPrice(int phone, double price);

}
