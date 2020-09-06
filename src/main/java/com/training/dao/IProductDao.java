package com.training.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.entity.ProductEntity;

@Repository
public interface IProductDao extends JpaRepository<ProductEntity, Long>{

	ProductEntity findByProductName(String productName);
	
	ProductEntity findByProductId(Long productId);
	
	ProductEntity findByProductNameAndProductIdNot(String productName, Long Id);

	
	
//	@Query("SELECT p FROM ProductEntity p JOIN BrandEntity b  "
//			+ "WHERE p.productName LIKE %?1% OR b.brandName LIKE %?2%"
//			)
//	Page<ProductEntity> findAll(String keyword , Pageable pageable);
	
	
	@Query(value = "SELECT p FROM ProductEntity p JOIN BrandEntity b ON p.brandEntity.brandId = b.brandId " 
			+ " WHERE (p.productName LIKE %:keyword% OR b.brandName LIKE %:keyword%)"
			+ " AND (p.price BETWEEN :priceFrom AND :toPrice)")
	Page<ProductEntity> searchProductByNameAndPrice(@Param("keyword") String keyword,@Param("priceFrom") double priceFrom, 
										   @Param("toPrice") double toPrice, Pageable pageable);

	
	Page<ProductEntity> findByPriceBetween(Double start , Double end ,Pageable pageable );
}
