package com.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "don_hang")
public class DonHangEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idDon_Hang", nullable = false)
	private int idDonHang;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sdt", referencedColumnName = "sdt")
	private KhachHangEntity khachHangEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "code", referencedColumnName = "code")
	private VoucherEntity voucherEntity;

	@Column(name = "Gia")
	private double minPrice;

	public DonHangEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDonHang() {
		return idDonHang;
	}

	

	public DonHangEntity(int idDonHang, KhachHangEntity khachHangEntity, VoucherEntity voucherEntity, double minPrice) {
		this.idDonHang = idDonHang;
		this.khachHangEntity = khachHangEntity;
		this.voucherEntity = voucherEntity;
		this.minPrice = minPrice;
	}

	public void setIdDonHang(int idDonHang) {
		this.idDonHang = idDonHang;
	}


	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public KhachHangEntity getKhachHangEntity() {
		return khachHangEntity;
	}

	public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
		this.khachHangEntity = khachHangEntity;
	}

	public VoucherEntity getVoucherEntity() {
		return voucherEntity;
	}

	public void setVoucherEntity(VoucherEntity voucherEntity) {
		this.voucherEntity = voucherEntity;
	}

}
