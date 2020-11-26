package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.entity.KhachHangEntity;

@Repository
public interface KhachHangDao extends JpaRepository<KhachHangEntity, Long> {

	@Query("SELECT u FROM KhachHangEntity u WHERE u.sdt Like ?1")
	List<KhachHangEntity> findBySdtLike(int sdt);
}
