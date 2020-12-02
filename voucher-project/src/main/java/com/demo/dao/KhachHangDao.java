package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;

@Repository
public interface KhachHangDao extends JpaRepository<KhachHangEntity, Long> {

	@Query("SELECT u FROM KhachHangEntity u WHERE u.sdt Like ?1")
	List<KhachHangEntity> findBySdtLike(int sdt);
	
	@Query("SELECT u FROM VoucherEntity u WHERE  u.status = :status AND u.minPrice <= :minPrice")
	List<VoucherEntity> findByMinPriceAndStatus(@Param("status") int status, @Param("minPrice") double minPrice);
	
	

	@Query("SELECT u FROM VoucherEntity u WHERE u.khachHangEntity.sdt Like ?1")
	List<VoucherEntity> findBySdt(int sdt);
}
