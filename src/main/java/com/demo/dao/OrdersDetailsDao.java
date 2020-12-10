package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.OrdersDetailsEntity;

@Repository
public interface OrdersDetailsDao extends JpaRepository<OrdersDetailsEntity, Long> {

	@Query(value = "select p from OrdersDetailsEntity p Group By p.customerEntity.phone")
	List<OrdersDetailsEntity> findAllPhone();

	@Query(value = "select p from OrdersDetailsEntity p where p.customerEntity.phone= :phone")
	List<OrdersDetailsEntity> findAllByPhone(@Param("phone") int phone);

	@Query(value = "SELECT p FROM OrdersDetailsEntity p JOIN VoucherEntity v ON p.voucherEntity.voucherCode = v.voucherCode WHERE (p.customerEntity.phone = :phone AND v.minPrice <= :price AND v.status = 0)")
	List<OrdersDetailsEntity> findVoucherByPhone(@Param("phone") int phone, @Param("price") double price);

}
