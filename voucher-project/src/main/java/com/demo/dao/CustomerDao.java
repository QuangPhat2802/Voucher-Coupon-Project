package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.CustomerEntity;
import com.demo.entity.VoucherEntity;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

	@Query("SELECT u FROM CustomerEntity u WHERE u.phone Like ?1")
	List<CustomerEntity> findByPhoneLike(int phone);
	
	@Query("SELECT u FROM VoucherEntity u WHERE  u.status = :status AND u.minPrice <= :minPrice")
	List<VoucherEntity> findByMinPriceAndStatus(@Param("status") int status, @Param("minPrice") double minPrice);
	
	@Query("SELECT u FROM VoucherEntity u WHERE u.customerEntity.phone Like ?1")
	List<VoucherEntity> findByPhone(int phone);
}
