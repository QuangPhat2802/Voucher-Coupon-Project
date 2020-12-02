package com.demo.service;

import java.util.List;

import com.demo.entity.DonHangEntity;

public interface DonHangService {

	DonHangEntity addDonHang(DonHangEntity donHangEntity);
	
	List<DonHangEntity> getListDonHang();



//	DonHangEntity addDonHang(int sdt, double minPrice, String code);
}
