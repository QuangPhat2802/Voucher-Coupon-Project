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

import com.demo.entity.VoucherEntity;
import com.demo.service.KhachHangService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/voucher")
public class VoucherController {

	@Autowired
	VoucherService voucherService;
	
	@Autowired
	KhachHangService khachHangService;
//	@GetMapping(value = "/addSdt")
//	public String initKhachHang(Model model) {
//		
//		model.addAttribute("listKH",khachHangService.getAll());
//		return "update" ; 
//	}
	
	@GetMapping
	public String initPage(Model model) {
		
		model.addAttribute("listVoucher", voucherService.getAll());
		return "index" ; 
	}
	@GetMapping("/code")
	public String check(Model model, @Param("code") String code) {
		model.addAttribute("listVoucher", voucherService.getAll());
		List<VoucherEntity> list = voucherService.searchCode(code);
		model.addAttribute("list" , list);
		
		return "index";
	}
	
	@GetMapping(value = "/addSdt")
	public String addSdt(@RequestParam("code") String code, Model model) {
		model.addAttribute("listKH",khachHangService.getAll());
		model.addAttribute("list", voucherService.searchCode(code));
		return "update";
	}
	
	
	@PostMapping(value = {"/addSdt"})
	public String addSdt(@ModelAttribute VoucherEntity voucherEntity, Model model,RedirectAttributes rd) {
		VoucherEntity voucherAdd = voucherService.addSdt(voucherEntity);
		
		return "redirect:/voucher";
	}
	
}
