package com.demo.service;

import java.util.List;

import com.demo.entity.KhachHangEntity;

public interface KhachHangService {
	
	List<KhachHangEntity> getAll();
	
	List<KhachHangEntity> searchKhachHang(int sdt);
	
	
	
}
