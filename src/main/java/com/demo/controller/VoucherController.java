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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.CustomerEntity;
import com.demo.entity.OrdersDetailsEntity;
import com.demo.entity.OrdersEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.CustomerService;
import com.demo.service.OrdersDetailsService;
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
	CustomerService customerService;

	@Autowired
	OrdersDetailsService ordersDetailsService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String initPage(Model model) {
		List<OrdersEntity> listOrders = ordersService.listOrders();
		model.addAttribute("listOrder", listOrders);
		model.addAttribute("listVoucher", voucherService.getAll());
		model.addAttribute("listPhoneAndVoucher", ordersDetailsService.getListPhoneAndVoucher());
		return "Voucher";
	}

	/**
	 * 
	 * @param voucherCode
	 * @param minPrice
	 * @param model
	 * @return
	 */
	@GetMapping("/code")
	public String checkVoucherCode(@Param("voucherCode") String voucherCode, @Param("price") double price,
			RedirectAttributes redirectAttributes) {
		List<VoucherEntity> listVoucher = voucherService.findByVoucherCodeAndPrice(voucherCode, price);
		if (listVoucher.isEmpty()) {
			redirectAttributes.addFlashAttribute("mess", "không thể sử dụng voucher");
		} else {
			redirectAttributes.addFlashAttribute("mess", "Voucher Có thể sử dụng");
		}
		return "redirect:/admin";
	}

	/**
	 * 
	 * @param ordersDetailsEntity
	 * @param customerEntity
	 * @param rd
	 * @return
	 */
	@PostMapping("/code")
	public String addVoucherToPhone(@ModelAttribute OrdersDetailsEntity ordersDetailsEntity,
			CustomerEntity customerEntity, RedirectAttributes redirectAttributes) {

		ordersDetailsService.addPhone(ordersDetailsEntity);
		return "redirect:/admin";

	}

	/**
	 * 
	 * @param phone
	 * @param model
	 * @param rd
	 * @return
	 */
	@GetMapping("/phone")
	public String findVoucherCodeByPhone(@Param("phone") int phone, Model model, RedirectAttributes redirectAttributes) {
		List<OrdersDetailsEntity> listVoucherCodeByPhone = ordersDetailsService.getListVoucherCodeByPhone(phone);
		redirectAttributes.addFlashAttribute("listVoucherCodeByPhone", listVoucherCodeByPhone);
		return "redirect:/admin";

	}

	/**
	 * 
	 * @param voucherCode
	 * @param price
	 * @param rd
	 * @return
	 */
	@PostMapping("/phone")
	public String checkVoucherByPrice(@Param("voucherCode") String voucherCode, @Param("price") double price,
			RedirectAttributes redirectAttributes) {

		List<VoucherEntity> listVoucherAndPrice = voucherService.findByVoucherCodeAndPrice(voucherCode, price);
		if (listVoucherAndPrice.isEmpty()) {
			redirectAttributes.addFlashAttribute("listVoucherAndPrice", "Không thể sử dụng Voucher");
		} else {
			redirectAttributes.addFlashAttribute("listVoucherAndPrice", "Voucher Có thể sử dụng");
		}
		return "redirect:/admin";

	}
}
