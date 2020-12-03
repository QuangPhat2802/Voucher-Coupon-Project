package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.CustomerEntity;
import com.demo.entity.OrdersEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.CustomerService;
import com.demo.service.OrdersService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	VoucherService voucherService;

	@Autowired
	CustomerService customerService;

	@Autowired
	OrdersService ordersService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String innitPage(Model model) {
		List<CustomerEntity> listSdt = customerService.getAll();
		model.addAttribute("listSdt", listSdt);
		return "Customer";
	}

	/**
	 * 
	 * @param sdt
	 * @param model
	 * @param customerEntity
	 * @param voucherEntity
	 * @param rd
	 * @return
	 */
	@GetMapping("/phone")
	public String searchCustomerByPhone(@Param("phone") int phone, Model model, CustomerEntity customerEntity,
			VoucherEntity voucherEntity) {
		List<VoucherEntity> listKH = customerService.searchCustomerByPhone(phone);
		model.addAttribute("listKH", listKH);
		return "Orders";
		
	}

	/**
	 * 
	 * @param sdt
	 * @param minPrice
	 * @param ordersEntity
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/phone")
	public String getListOrders(@Param("phone") int phone, @Param("minPrice") double minPrice,
			CustomerEntity customerEntity, VoucherEntity voucherEntity, Model model) {
		
		searchCustomerByPhone(phone, model, customerEntity, voucherEntity);
		List<VoucherEntity> listVoucher = voucherService.findVoucherCodeByPhone(phone, minPrice);
		model.addAttribute("listVoucher", listVoucher);
		model.addAttribute("minPrice", voucherEntity.getMinPrice());
		return "add";

	}

	/**
	 * @param sdt
	 * @param minPrice
	 * @param voucherCode
	 * @param customerEntity
	 * @param voucherEntity
	 * @param ordersEntity
	 * @return
	 */
	@PostMapping(value = "/add")
	public String addOrders(@Param("phone") int phone, @Param("minPrice") double minPrice,
			@Param("voucherCode") String voucherCode, CustomerEntity customerEntity, VoucherEntity voucherEntity,
			OrdersEntity ordersEntity) {
		
		ordersService.addOrders(ordersEntity);
		return "add";

	}
}