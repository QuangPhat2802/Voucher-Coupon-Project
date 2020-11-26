package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.VoucherEntity;

@Repository
public interface VoucherDao extends JpaRepository<VoucherEntity, String>  {

	
	@Query("SELECT u FROM VoucherEntity u WHERE u.code Like ?1")
	List<VoucherEntity> findByCodeLike(String code);
	
	@Query("SELECT u FROM VoucherEntity u WHERE u.status = 0")
	List<VoucherEntity> findByStatusLike(int status);
	
}
