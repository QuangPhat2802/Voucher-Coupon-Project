package com.training.service;

import java.util.List;

import com.training.entity.ProductEntity;
import com.training.model.ResponseDataModel;

public interface IProductService {
	
	List<ProductEntity> getAll();
	
	ResponseDataModel addProduct(ProductEntity productEntity);
	
	ProductEntity findByProductName(String productName);
	
	ResponseDataModel findAllWithPaper(int papeNumber);
	
	ResponseDataModel findByProductId(Long productId);
	
	ResponseDataModel updateProduct(ProductEntity productEntity);
	
	ResponseDataModel deleteProduct(Long productId);
	
	ResponseDataModel searchByPriceBetween(Double startPrice , Double endPrice , int pageNumber);
	
	ResponseDataModel searchByNameAndPrice(String keyword,int pageNumber ,double startPrice,double endPrice);
}
