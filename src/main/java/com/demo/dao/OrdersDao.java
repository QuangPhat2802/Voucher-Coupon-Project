package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.OrdersEntity;

@Repository
public interface OrdersDao extends JpaRepository<OrdersEntity, Long> {

}
