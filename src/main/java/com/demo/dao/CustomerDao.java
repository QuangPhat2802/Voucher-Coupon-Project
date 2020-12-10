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

	@Query("SELECT u FROM VoucherEntity u WHERE  u.status = :status AND u.minPrice <= :price")
	List<VoucherEntity> findByMinPriceAndStatus(@Param("status") int status, @Param("price") double price);

	CustomerEntity findByPhone(int phone);

}
