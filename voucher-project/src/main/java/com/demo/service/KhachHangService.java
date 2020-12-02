package com.demo.service;

import java.util.List;

import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;

public interface KhachHangService {
	
	List<KhachHangEntity> getAll();
	
	List<VoucherEntity> searchKhachHang(int sdt);
	
//	List<VoucherEntity> findByMinPriceAndStatus(int status , double minPrice);
	
	
	
}
