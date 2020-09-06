package com.training.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.training.common.constant.Constants;
import com.training.common.util.FileHelper;
import com.training.dao.IProductDao;
import com.training.entity.ProductEntity;
import com.training.model.PagerModel;
import com.training.model.ResponseDataModel;
import com.training.service.IProductService;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Value("${parent.folder.images.product}")
	private String productImageFolderPath;
	
	@Autowired
	IProductDao productDao;
	@Override
	public List<ProductEntity> getAll() {
		return productDao.findAll();
	}
	
	@Override
	public ProductEntity findByProductName(String productName) {
		return productDao.findByProductName(productName);
	}
	
	@Override
	public ResponseDataModel addProduct(ProductEntity productEntity) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		try {
			if(findByProductName(productEntity.getProductName()) != null) {
				responseCode = Constants.RESULT_CD_DUPL;
				responseMsg = "duplicate";
			}else {
				MultipartFile[] imageFiles = productEntity.getImageFiles();
				if(imageFiles != null && imageFiles[0].getSize() > 0) {
					String imagePath = FileHelper.addNewFile(productImageFolderPath, imageFiles);
					productEntity.setImage(imagePath);
				}
				productDao.saveAndFlush(productEntity);
				responseCode = Constants.RESULT_CD_SUCCESS;
				responseMsg = "Product is added successfully";
				
			}
		} catch (Exception e) {
			responseMsg = "Error when adding brand";
			LOGGER.error("Error when get all brand: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg);
	}

	@Override
	public ResponseDataModel findAllWithPaper(int pageNumber) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		Map<String, Object> responseMap = new HashMap<>();
		try {
		Sort sort = Sort.by(Sort.Direction.DESC, "productId");
		Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE,sort);
		Page<ProductEntity> productEntityPage = productDao.findAll(pageable);
		responseMap.put("productList", productEntityPage.getContent());
		responseMap.put("paginationInfo", new PagerModel(pageNumber, productEntityPage.getTotalPages()));
		responseCode = Constants.RESULT_CD_SUCCESS;
		} catch (Exception e) {
			responseMsg = e.getMessage();
			LOGGER.error("Error when get all product: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg,responseMap);
	}

	@Override
	public ResponseDataModel findByProductId(Long productId) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		ProductEntity productEntity = null;
		try {
			productEntity = productDao.findByProductId(productId);
			if (productEntity != null) {
				responseCode = Constants.RESULT_CD_SUCCESS;
			}
		} catch (Exception e) {
			responseMsg = ("error");
			LOGGER.error("error when get all by productId", e);
		}

		return new ResponseDataModel(responseCode, responseMsg, productEntity);
	}

	@Override
	public ResponseDataModel updateProduct(ProductEntity productEntity) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		try {
			ProductEntity productEntityUpdated = productDao.findByProductNameAndProductIdNot(productEntity.getProductName(),
					productEntity.getProductId());
			if(productEntityUpdated != null) {
				responseMsg = "Product Name is duplicated";
				responseCode = Constants.RESULT_CD_DUPL;
			}else {
				MultipartFile[] imageFiles = productEntity.getImageFiles();
				if(imageFiles != null && imageFiles[0].getSize() > 0) {
					String imagePath = FileHelper.editFile(productImageFolderPath, imageFiles, productEntity.getImage());
					productEntity.setImage(imagePath);
				}
				productDao.saveAndFlush(productEntity);
				responseCode = Constants.RESULT_CD_SUCCESS;
				responseMsg = "Product is updated successfully";
			}
		} catch (Exception e) {
			responseMsg = "Error when updating product";
			LOGGER.error("Errorr when updating product: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg);
	}

	@Override
	public ResponseDataModel deleteProduct(Long productId) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		ProductEntity productEntity = productDao.findByProductId(productId);
		try {
			if(productEntity != null) {
				productDao.deleteById(productId);
				productDao.flush();
				FileHelper.deleteFile(productEntity.getImage());
				 responseCode = Constants.RESULT_CD_SUCCESS;
				 responseMsg = "Product is deleted successfully";
			}
			
		} catch (Exception e) {
			responseMsg = "Error when delete product";
			LOGGER.error("Error when delete product: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg);
	}

	@Override
	public ResponseDataModel searchByPriceBetween(Double startPrice, Double endPrice , int pageNumber) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		Map<String, Object> rpMap = new HashMap<>();
		try {
//			List<ProductEntity> list = productDao.findByPriceBetween(startPrice, endPrice);
			Sort sortInfo = Sort.by(Sort.Direction.DESC, "productId");
			Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sortInfo);
			Page<ProductEntity> pages =productDao.findByPriceBetween(startPrice, endPrice, pageable);
			rpMap.put("productList", pages.getContent());
			rpMap.put("paginationInfo", new PagerModel(pageNumber, pages.getTotalPages()));
			responseCode = Constants.RESULT_CD_SUCCESS;
			responseMsg = "ResultSet has "  + " products";
		} catch (Exception e) {
			responseMsg = e.getMessage();
			LOGGER.error("Error when get all product: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg, rpMap);
	}

	@Override
	public ResponseDataModel searchByNameAndPrice(String keyword, int pageNumber, double startPrice, double endPrice) {
		int responseCode = Constants.RESULT_CD_FAIL;
		String responseMsg = StringUtils.EMPTY;
		Map<String, Object> rpMap = new HashMap<>();
		try {
			Sort sort = Sort.by(Sort.Direction.DESC,"productId");
			Pageable pageable = PageRequest.of(pageNumber - 1, Constants.PAGE_SIZE, sort);
			Page<ProductEntity> pages = productDao.searchProductByNameAndPrice("%"+ keyword +"%", startPrice, endPrice, pageable);
			rpMap.put("productList", pages.getContent());
			rpMap.put("paginationInfo", new PagerModel(pageNumber, pages.getTotalPages()));
			responseCode = Constants.RESULT_CD_SUCCESS;
			responseMsg = "ResultSet has " +  pages.getTotalElements()  + " products";
		} catch (Exception e) {
			responseMsg = e.getMessage();
			LOGGER.error("Error when get all product: ", e);
		}
		return new ResponseDataModel(responseCode, responseMsg, rpMap);
	}




}
