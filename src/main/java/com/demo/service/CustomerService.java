package com.demo.service;

import java.util.List;

import com.demo.entity.CustomerEntity;

public interface CustomerService {

	List<CustomerEntity> getAll();

	CustomerEntity findByPhone(int phone);

}
