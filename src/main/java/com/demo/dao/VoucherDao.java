package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.VoucherEntity;

@Repository
public interface VoucherDao extends JpaRepository<VoucherEntity, String> {

	VoucherEntity findByVoucherCode(String voucherCode);

	@Query("SELECT u FROM VoucherEntity u WHERE  u.voucherCode = :voucherCode AND u.minPrice <= :price")
	List<VoucherEntity> findByVoucherCodeAndPrice(@Param("voucherCode") String voucherCode, @Param("price") double price);

	@Query("SELECT u FROM VoucherEntity u WHERE u.status = ?1")
	List<VoucherEntity> findByStatusLike(int status);

}
