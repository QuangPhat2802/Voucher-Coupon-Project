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

import com.demo.entity.DonHangEntity;
import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.DonHangService;
import com.demo.service.KhachHangService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/admin")
public class VoucherController {

	@Autowired
	DonHangService donHangService;
	@Autowired
	VoucherService voucherService;

	@Autowired
	KhachHangService khachHangService;

	/**
	 * 
	 * @param voucherEntity
	 * @param model
	 * @return
	 */
	@GetMapping
	public String initPage(VoucherEntity voucherEntity, Model model) {
		model.addAttribute("listVoucher", voucherService.getAll());
		List<DonHangEntity> listDonHang = donHangService.getListDonHang();
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
	public String check(Model model, @Param("sdt") int sdt, @Param("minPrice") double minPrice,
			VoucherEntity voucherEntity, RedirectAttributes rd) {
		model.addAttribute("listVoucher", voucherService.getAll());
		List<VoucherEntity> list = voucherService.searchCodeBySdt(sdt, minPrice);
		List<DonHangEntity> listDonHang = donHangService.getListDonHang();
		model.addAttribute("listDonHang", listDonHang);
		if (list != null) {
			model.addAttribute("list", list);
		}
		return "admin";
	}

	/**
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@GetMapping("/sdt")
	public String initAddSdt(@RequestParam(name = "code") String code, Model model) {
		List<KhachHangEntity> listKhachHang = khachHangService.getAll();
		model.addAttribute("listKhachHang", listKhachHang);
		model.addAttribute("code", voucherService.findByCode(code));
		return "update";
	}
	/**
	 * 
	 * @param voucherEntity
	 * @param model
	 * @return
	 */
	@PostMapping("/sdt")
	public String addSdt(@ModelAttribute VoucherEntity voucherEntity, Model model, RedirectAttributes rd) {
		VoucherEntity update = voucherService.addSdt(voucherEntity);
		return "redirect:/admin";
	}
}
