//package com.demo.entity;
//
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name= "don_hang")
//public class DonHangEntity {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "idDon_Hang",nullable = false)
//	private int idDonHang;
//	
//	
//	@Column(name = "sdt", nullable = false)
//	private int sdt;
//	
//	@Column(name = "code" , nullable = false)
//	private int code;
//	
//	@Column(name = "Gia",nullable = false)
//	private double gia;
//	
//	  @OneToOne
//	  @JoinColumn(name = "sdt", nullable = false)
//	  private KhachHangEntity khachHangEntity;
//	  
//	  @JsonIgnore
//		@OneToMany(mappedBy = "donhangEntity", fetch = FetchType.LAZY)
//		private Set<VoucherEntity> voucherSet;
//
//public DonHangEntity() {
//	// TODO Auto-generated constructor stub
//}
//
//public int getIdDonHang() {
//	return idDonHang;
//}
//
//public void setIdDonHang(int idDonHang) {
//	this.idDonHang = idDonHang;
//}
//
//public int getSdt() {
//	return sdt;
//}
//
//public void setSdt(int sdt) {
//	this.sdt = sdt;
//}
//
//public int getCode() {
//	return code;
//}
//
//public void setCode(int code) {
//	this.code = code;
//}
//
//public double getGia() {
//	return gia;
//}
//
//public void setGia(double gia) {
//	this.gia = gia;
//}
//
//public KhachHangEntity getKhachHangEntity() {
//	return khachHangEntity;
//}
//
//public void setKhachHangEntity(KhachHangEntity khachHangEntity) {
//	this.khachHangEntity = khachHangEntity;
//}
//
//public Set<VoucherEntity> getVoucherSet() {
//	return voucherSet;
//}
//
//public void setVoucherSet(Set<VoucherEntity> voucherSet) {
//	this.voucherSet = voucherSet;
//}
//
//
//}
//
