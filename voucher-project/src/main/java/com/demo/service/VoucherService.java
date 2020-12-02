package com.demo.service;

import java.util.List;

import com.demo.entity.VoucherEntity;

public interface VoucherService {

	List<VoucherEntity> getAll();

	List<VoucherEntity> searchCodeBySdt(int sdt, double minPrice);

	VoucherEntity addSdt(VoucherEntity voucherEntity);

	List<VoucherEntity> searchStatus(int status);

	// List<VoucherEntity> checkStt(int status);
	
	VoucherEntity findByCode(String code);
	


}
