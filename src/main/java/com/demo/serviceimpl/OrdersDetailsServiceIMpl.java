package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.OrdersDetailsDao;
import com.demo.entity.OrdersDetailsEntity;
import com.demo.service.OrdersDetailsService;

@Service
public class OrdersDetailsServiceIMpl implements OrdersDetailsService {

	@Autowired
	OrdersDetailsDao ordersDetailsDao;

	@Override
	public OrdersDetailsEntity addPhone(OrdersDetailsEntity ordersDetailsEntity) {
		// TODO Auto-generated method stub
		return ordersDetailsDao.saveAndFlush(ordersDetailsEntity);
	}

	@Override
	public List<OrdersDetailsEntity> getListPhoneAndVoucher() {
		// TODO Auto-generated method stub
		return ordersDetailsDao.findAllPhone();
	}

	@Override
	public List<OrdersDetailsEntity> getListVoucherCodeByPhone(int phone) {
		// TODO Auto-generated method stub
		return ordersDetailsDao.findAllByPhone(phone);
	}

	@Override
	public List<OrdersDetailsEntity> getListVoucherByPhoneAndPrice(int phone, double price) {

		return ordersDetailsDao.findVoucherByPhone(phone, price);
	}

}
