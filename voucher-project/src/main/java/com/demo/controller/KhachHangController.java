package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.entity.DonHangEntity;
import com.demo.entity.KhachHangEntity;
import com.demo.entity.VoucherEntity;
import com.demo.service.DonHangService;
import com.demo.service.KhachHangService;
import com.demo.service.VoucherService;

@Controller
@RequestMapping(value = "/KH")
public class KhachHangController {

	@Autowired
	VoucherService voucherService;

	@Autowired
	KhachHangService khachHangService;

	@Autowired
	DonHangService donHangService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String innitPage(Model model) {
		// model.addAttribute("listVoucher",voucherService.getAll() );
		List<KhachHangEntity> listSdt = khachHangService.getAll();
		model.addAttribute("listSdt", listSdt);
		return "KhachHang";
	}

	/**
	 * 
	 * @param sdt
	 * @param model
	 * @param khachHangEntity
	 * @param voucherEntity
	 * @param rd
	 * @return
	 */
	@GetMapping("/sdt")
	public String searchKhachHang(@Param("sdt") int sdt, Model model, KhachHangEntity khachHangEntity,
			VoucherEntity voucherEntity, RedirectAttributes rd) {

		List<VoucherEntity> listKH = khachHangService.searchKhachHang(sdt);
		model.addAttribute("listKH", listKH);
		return "DonHang";

	}

	/**
	 * 
	 * @param sdt
	 * @param minPrice
	 * @param donHangEntity
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/sdt")
	public String checkDonHang(@Param("sdt") int sdt, @Param("minPrice") double minPrice,
			KhachHangEntity khachHangEntity, VoucherEntity voucherEntity, Model model, RedirectAttributes rd) {
		List<VoucherEntity> listKH = khachHangService.searchKhachHang(sdt);
		List<VoucherEntity> listVoucher = voucherService.searchCodeBySdt(sdt, minPrice);
		model.addAttribute("listVoucher", listVoucher);
		model.addAttribute("listKH", listKH);
		model.addAttribute("minPrice", voucherEntity.getMinPrice());
		return "add";

	}

	@PostMapping(value = "/add")
	public String addDonHang(@Param("sdt") int sdt, @Param("minPrice") double minPrice, @Param("code") String code,
			KhachHangEntity khachHangEntity, VoucherEntity voucherEntity, DonHangEntity donHangEntity) {

		DonHangEntity dh = donHangService.addDonHang(donHangEntity);

		return "add";
	}

}
