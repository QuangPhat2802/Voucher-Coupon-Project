package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.DonHangEntity;

@Repository
public interface DonHangDao extends JpaRepository<DonHangEntity, Long> {

	



	
}
