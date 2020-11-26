package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.KhachHangDao;
import com.demo.entity.KhachHangEntity;
import com.demo.service.KhachHangService;

@Service
public class KhachHangServiceIMpl implements KhachHangService{

	@Autowired
	KhachHangDao khachHangDao;

	@Override
	public List<KhachHangEntity> searchKhachHang(int sdt) {
		// TODO Auto-generated method stub
		return khachHangDao.findBySdtLike(sdt);
	}

	@Override
	public List<KhachHangEntity> getAll() {
		// TODO Auto-generated method stub
		return khachHangDao.findAll();
	}


}
