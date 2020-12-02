package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.VoucherDao;
import com.demo.entity.VoucherEntity;
import com.demo.service.VoucherService;

@Service
@Transactional
public class VoucherServiceIMpl implements VoucherService {

	@Autowired
	VoucherDao voucherDao;

	@Override
	public List<VoucherEntity> getAll() {
		// TODO Auto-generated method stub
		return voucherDao.findAll();
	}

	@Override
	public List<VoucherEntity> searchCodeBySdt(int sdt, double minPrice) {
		// TODO Auto-generated method stub
		return voucherDao.findBySdtLike(sdt, minPrice);
	}

	@Override
	public VoucherEntity addSdt(VoucherEntity voucherEntity) {
		// TODO Auto-generated method stub
		return voucherDao.saveAndFlush(voucherEntity);
	}

	@Override
	public List<VoucherEntity> searchStatus(int status) {

		if (status == 0) {

		}

		return voucherDao.findByStatusLike(status);
	}

	@Override
	public VoucherEntity findByCode(String code) {

		return voucherDao.findByCode(code);
	}

}
