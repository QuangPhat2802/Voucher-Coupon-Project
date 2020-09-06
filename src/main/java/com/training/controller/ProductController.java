package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.entity.ProductEntity;
import com.training.model.ResponseDataModel;
import com.training.service.IBrandService;
import com.training.service.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	IProductService productService;
	
	
	@Autowired
	IBrandService brandService;
	
	@GetMapping
	public String initBrandPage(Model model) {
		model.addAttribute("brandList", brandService.getAll());
		return "product-index";
	}
//	@GetMapping
//	public String initPage(Model model) {
//		model.addAttribute("productList",productService.getAll());
//		return "product-index";
//	}
	
	@PostMapping(value = "/api/add")
	@ResponseBody
	public ResponseDataModel addProduct(@ModelAttribute ProductEntity productEntity) {
		return productService.addProduct(productEntity);
	}
	
	@GetMapping(value = "/api/findAll/{pageNumber}")
	@ResponseBody
	public ResponseDataModel findAllWithPaper(@PathVariable("pageNumber") int pageNumber) {
		return productService.findAllWithPaper(pageNumber);
	}
	
	@GetMapping(value = "/api/findAll")
	@ResponseBody
	public ResponseDataModel findByProductId(@RequestParam("id") Long productId) {
		return productService.findByProductId(productId);
	}
	
	@PostMapping(value = "/api/update")
	@ResponseBody
	public ResponseDataModel updateProduct(@ModelAttribute ProductEntity productEntity) {
		
		return productService.updateProduct(productEntity);
	}
	
	@DeleteMapping(value = "/api/delete/{productId}")
	@ResponseBody
	public ResponseDataModel deleteProduct(@PathVariable("productId") Long productId) {
		return productService.deleteProduct(productId);
	}
	
	
	@GetMapping(value = "/api/searchPrice/{startKey}/{endKey}/{pageNumber}")
	@ResponseBody
	public ResponseDataModel searchPrice(@PathVariable("startKey") Double startKey, @PathVariable("endKey") Double endKey,
			 @PathVariable("pageNumber") int pageNumber) {
				return productService.searchByPriceBetween(startKey, endKey,pageNumber);
	}
	
	@GetMapping(value = "/api/search/{keyword}/{pageNumber}/{priceFrom}/{toPrice}")
	@ResponseBody
	public ResponseDataModel searchByNameAndPrice(@PathVariable("keyword") String keyword, @PathVariable("pageNumber") int pageNumber,
				@PathVariable("priceFrom") double priceFrom, @PathVariable("toPrice") double toPrice) {
		return productService.searchByNameAndPrice(keyword, pageNumber, priceFrom, toPrice);
	}
	
}
