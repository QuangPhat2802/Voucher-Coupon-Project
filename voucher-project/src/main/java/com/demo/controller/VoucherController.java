package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.CustomerEntity;
import com.demo.entity.OrdersEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.CustomerService;
import com.demo.service.OrdersService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/admin")
public class VoucherController {

	@Autowired
	OrdersService ordersService;

	@Autowired
	VoucherService voucherService;

	@Autowired
	CustomerService khachHangService;

	/**
	 * 
	 * @param voucherEntity
	 * @param model
	 * @return
	 */
	@GetMapping
	public String initPage(VoucherEntity voucherEntity, Model model) {
		model.addAttribute("listVoucher", voucherService.getAll());
		List<OrdersEntity> listDonHang = ordersService.getListOrders();
		model.addAttribute("listDonHang", listDonHang);
		return "admin";
	}

	/**
	 * 
	 * @param model
	 * @param code
	 * @param minPrice
	 * @param voucherEntity
	 * @param rd
	 * @return
	 */
	@GetMapping("/code")
	public String findByPhoneAndPrice(Model model, @Param("phone") int phone, @Param("minPrice") double minPrice,
			VoucherEntity voucherEntity) {
		List<VoucherEntity> list = voucherService.findVoucherCodeByPhone(phone, minPrice);
		initPage(voucherEntity, model);
		model.addAttribute("list", list);
		return "admin";
	
		
	}

	/**
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@GetMapping("/phone")
	public String initAddPhone(@RequestParam(name = "voucherCode") String voucherCode, Model model) {
		List<CustomerEntity> listKhachHang = khachHangService.getAll();
		model.addAttribute("listKhachHang", listKhachHang);
		model.addAttribute("code", voucherService.findByVoucherCode(voucherCode));
		return "update";
	}

	/**
	 * 
	 * @param voucherEntity
	 * @param model
	 * @return
	 */
	@PostMapping("/phone")
	public String addPhone(@ModelAttribute VoucherEntity voucherEntity, Model model) {
		VoucherEntity update = voucherService.addPhone(voucherEntity);
		return "redirect:/admin";
	}

}
