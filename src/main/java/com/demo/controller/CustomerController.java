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
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	VoucherService voucherService;

	@Autowired
	CustomerService customerService;

	@Autowired
	OrdersService ordersService;

	@Autowired
	OrdersDetailsService ordersDetailsService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String innitPage(Model model) {
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
	public String searchCustomerByPhone(@Param("phone") int phone, Model model) {
		CustomerEntity customerEntity = customerService.findByPhone(phone);

		model.addAttribute("customerEntity", customerEntity);
		List<OrdersDetailsEntity> listVoucher = ordersDetailsService.getListVoucherCodeByPhone(phone);
		model.addAttribute("listVoucher", listVoucher);
		return "Customer";

	}

	/**
	 * 
	 * @param phone
	 * @param price
	 * @param rd
	 * @param customerEntity
	 * @param ordersEntity
	 * @return
	 */
	@PostMapping("/phone")
	public String getListVoucherByPhone(@Param("phone") int phone, @RequestParam("price") double price,
			RedirectAttributes redirectAttributes, CustomerEntity customerEntity, OrdersEntity ordersEntity) {

		List<OrdersDetailsEntity> listVoucherByPhoneAndPrice = ordersDetailsService.getListVoucherByPhoneAndPrice(phone,
				price);
		redirectAttributes.addFlashAttribute("listVoucherByPhoneAndPrice", listVoucherByPhoneAndPrice);
		redirectAttributes.addFlashAttribute("price", ordersEntity.getPrice());
		return "redirect:/customer/phone?phone=" + customerEntity.getPhone();
	}

	/**
	 * 
	 * @param price
	 * @param voucherCode
	 * @param ordersEntity
	 * @param rd
	 * @return @Param("voucherCode") String voucherCode,
	 */
	@GetMapping("/price")
	public String checkPrice(@Param("price") double price, OrdersEntity ordersEntity, RedirectAttributes redirectAttributes) {

		VoucherEntity check = voucherService.findByVoucherCode(ordersEntity.getVoucherEntity().getVoucherCode());
		if (price >= 2 * check.getMinPrice()) {
			redirectAttributes.addFlashAttribute("price", price - check.getMaxPriceDiscount());
		} else {
			redirectAttributes.addFlashAttribute("price", price - (price * (check.getDiscount()) / 100));
		}
		redirectAttributes.addFlashAttribute("totalprice", ordersEntity.getPrice());
		redirectAttributes.addFlashAttribute("getVoucher", ordersEntity);
		return "redirect:/customer/phone?phone=" + ordersEntity.getCustomerEntity().getPhone();
	}

	/**
	 * 
	 * @param ordersEntity
	 * @param rd
	 * @return
	 */
	@PostMapping(value = "/add")
	public String addOrders(@ModelAttribute OrdersEntity ordersEntity, RedirectAttributes redirectAttributes) {
		ordersService.addOrders(ordersEntity);

		return "redirect:/customer/phone?phone=" + ordersEntity.getCustomerEntity().getPhone();
	}

}