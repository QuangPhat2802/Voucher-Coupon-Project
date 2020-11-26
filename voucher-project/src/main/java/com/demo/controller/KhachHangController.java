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

import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.KhachHangService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/KH")
public class KhachHangController {

	@Autowired
	VoucherService voucherService;
	
	@Autowired
	KhachHangService khachHangService;

	@GetMapping
	public String innitPage() {
		// model.addAttribute("listVoucher",voucherService.getAll() );
		return "KhachHang";
	}

	// @GetMapping("/sdt")
	// public String innitPage(Model model) {
	// model.addAttribute("listVoucher",voucherService.getAll() );
	// return "DonHang";
	// }
	@GetMapping("/sdt")
	public String searchKhachHang(@Param("sdt") int sdt, Model model, KhachHangEntity khachHangEntity,
			VoucherEntity voucherEntity, RedirectAttributes rd) {

		List<KhachHangEntity> listKH = khachHangService.searchKhachHang(sdt);

		if (listKH.isEmpty()) {
			return "redirect:/KH";
		} else {
			model.addAttribute("listStatus", voucherService.searchStatus(voucherEntity.getStatus()));
			model.addAttribute("listVoucher", voucherService.getAll());
			model.addAttribute("listKH", listKH);
			return "DonHang";
		}

	}
	
	@PostMapping(value = "/sdt")
	public String addDonHang(@ModelAttribute KhachHangEntity khachHangEntity , VoucherEntity voucherEntity, Model model) {
		
		
		return null;
	}

}
