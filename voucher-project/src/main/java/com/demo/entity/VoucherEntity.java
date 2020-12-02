package com.demo.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "voucher_project")
public class VoucherEntity {

	@Id
	@Column(name = "code" , nullable = false)
	private String code;
	
	@Column(name = "name" )
	private String name;
	
	@Column(name = "description" )
	private String description;
	
	@Column(name = "quantity" )
	private int quantity;
	
	@Column(name = "discount" )
	private int discount;
	
	@Column(name = "startDate" )
	private Date startDate;
	
	@Column(name = "endDate" )
	private Date endDate;
	
	@Column(name = "status" )
	private int status;
	
	@Column(name = "minPrice")
	private double minPrice;

	@JsonIgnore
	@OneToMany(mappedBy = "voucherEntity", fetch = FetchType.LAZY)
	private Set<DonHangEntity> donHangEntity;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sdt", referencedColumnName = "sdt")
	private KhachHangEntity khachHangEntity;
	
//	@OneToOne( fetch = FetchType.LAZY)
//	@JoinColumn(name="code")
//	private DonHangEntity donHangEntity;

	
	public VoucherEntity() {
		// TODO Auto-generated constructor stub
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Set<DonHangEntity> getDonHangEntity() {
		return donHangEntity;
	}


	public void setDonHangEntity(Set<DonHangEntity> donHangEntity) {
		this.donHangEntity = donHangEntity;
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



	
}
