package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.KhachHangDao;
import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.KhachHangService;

@Transactional
@Service
public class KhachHangServiceIMpl implements KhachHangService{

	@Autowired
	KhachHangDao khachHangDao;

	@Override
	public List<VoucherEntity> searchKhachHang(int sdt) {
		// TODO Auto-generated method stub
		return khachHangDao.findBySdt(sdt);
	}

	@Override
	public List<KhachHangEntity> getAll() {
		// TODO Auto-generated method stub
		return khachHangDao.findAll();
	}

//	@Override
//	public List<VoucherEntity> findByMinPriceAndStatus(int status, double minPrice) {
//		
//		return khachHangDao.findByMinPriceAndStatus(status, minPrice);
//	}


}
