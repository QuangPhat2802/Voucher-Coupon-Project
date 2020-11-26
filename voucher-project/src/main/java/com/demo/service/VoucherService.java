package com.demo.service;

import java.util.List;

import com.demo.entity.VoucherEntity;

public interface VoucherService {

	List<VoucherEntity> getAll();
	
	List<VoucherEntity> searchCode(String code);
	
	VoucherEntity addSdt(VoucherEntity voucherEntity);
	
	List<VoucherEntity> searchStatus(int status);
}
