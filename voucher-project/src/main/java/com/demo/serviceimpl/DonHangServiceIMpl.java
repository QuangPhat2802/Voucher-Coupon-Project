package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.OrdersDao;
import com.demo.entity.OrdersEntity;
import com.demo.service.OrdersService;

@Transactional
@Service
public class DonHangServiceIMpl implements OrdersService {

	@Autowired
	OrdersDao ordersDao;

	@Override
	public OrdersEntity addOrders(OrdersEntity donHangEntity) {
		// TODO Auto-generated method stub
		return ordersDao.saveAndFlush(donHangEntity);
	}

	@Override
	public List<OrdersEntity> getListOrders() {
		// TODO Auto-generated method stub
		return ordersDao.findAll();
	}

}
