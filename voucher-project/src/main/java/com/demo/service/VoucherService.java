package com.demo.service;

import java.util.List;

import com.demo.entity.VoucherEntity;

public interface VoucherService {

	List<VoucherEntity> getAll();

	List<VoucherEntity> findVoucherCodeByPhone(int phone, double minPrice);

	VoucherEntity addPhone(VoucherEntity voucherEntity);

	List<VoucherEntity> searchVoucherByStatus(int status);

	VoucherEntity findByVoucherCode(String voucherCode);

}
