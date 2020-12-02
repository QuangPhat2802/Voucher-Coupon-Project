package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.DonHangDao;
import com.demo.entity.DonHangEntity;
import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.DonHangService;

@Transactional
@Service
public class DonHangServiceIMpl implements DonHangService {

	@Autowired
	DonHangDao donHangDao;
	
	@Override
	public DonHangEntity addDonHang(DonHangEntity donHangEntity) {
		// TODO Auto-generated method stub
		return donHangDao.saveAndFlush(donHangEntity);
	}

	@Override
	public List<DonHangEntity> getListDonHang() {
		// TODO Auto-generated method stub
		return donHangDao.findAll();
	}



	
}
