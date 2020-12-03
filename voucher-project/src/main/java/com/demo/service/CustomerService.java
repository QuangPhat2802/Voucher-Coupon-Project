package com.demo.service;

import java.util.List;

import com.demo.entity.CustomerEntity;
import com.demo.entity.VoucherEntity;

public interface CustomerService {
	
	List<CustomerEntity> getAll();

	List<VoucherEntity> searchCustomerByPhone(int phone);
}
