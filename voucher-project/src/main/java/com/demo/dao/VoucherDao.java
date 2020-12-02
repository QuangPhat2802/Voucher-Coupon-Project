package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.VoucherEntity;

@Repository
public interface VoucherDao extends JpaRepository<VoucherEntity, String> {
	
	VoucherEntity findByCode(String code);
	

//	@Query("SELECT u FROM VoucherEntity u WHERE  u.code = :code AND u.minPrice <= :minPrice")
//	List<VoucherEntity> findByCodeLike(@Param("code") String code, @Param("minPrice") double minPrice);
	
	@Query("SELECT u FROM VoucherEntity u WHERE  u.khachHangEntity.sdt = :sdt AND u.minPrice <= :minPrice")
	List<VoucherEntity> findBySdtLike(@Param("sdt") int sdt, @Param("minPrice") double minPrice);

	// @Query("SELECT u FROM VoucherEntity u WHERE u.status = ?1")
	// List<VoucherEntity> findByStatusLike(int status);

	@Query("SELECT u FROM VoucherEntity u WHERE u.status = ?1")
	List<VoucherEntity> findByStatusLike(int status);
	
	
}
