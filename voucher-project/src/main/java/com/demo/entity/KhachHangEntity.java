package com.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "khach_hang")
public class KhachHangEntity {

	@Id
	@Column(name = "sdt", nullable = false)
	private int sdt;

	@Column(name = "tenKH")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "khachHangEntity", fetch = FetchType.LAZY)
	private Set<DonHangEntity> donHangEntity;

	@OneToMany(mappedBy = "khachHangEntity",fetch = FetchType.LAZY)
	private Set<VoucherEntity> voucherEntity;
	
	// @JsonIgnore
	// @OneToMany(mappedBy = "khachhangEntity", fetch = FetchType.LAZY)
	// private Set<VoucherEntity> voucherSet;

	

	public Set<DonHangEntity> getDonHangEntity() {
		return donHangEntity;
	}

	public void setDonHangEntity(Set<DonHangEntity> donHangEntity) {
		this.donHangEntity = donHangEntity;
	}

	public KhachHangEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<VoucherEntity> getVoucherEntity() {
		return voucherEntity;
	}

	public void setVoucherEntity(Set<VoucherEntity> voucherEntity) {
		this.voucherEntity = voucherEntity;
	}


}
