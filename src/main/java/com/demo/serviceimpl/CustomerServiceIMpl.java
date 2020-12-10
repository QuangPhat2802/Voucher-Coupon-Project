package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CustomerDao;
import com.demo.entity.CustomerEntity;
import com.demo.service.CustomerService;

@Transactional
@Service
public class CustomerServiceIMpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public List<CustomerEntity> getAll() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}

	@Override
	public CustomerEntity findByPhone(int phone) {

		return customerDao.findByPhone(phone);
	}

}
