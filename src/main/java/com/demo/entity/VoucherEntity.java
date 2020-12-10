package com.demo.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "voucher")
public class VoucherEntity {

	@Id
	@Column(name = "voucher_code", nullable = false)
	private String voucherCode;

	@Column(name = "voucher_name")
	private String voucherName;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "discount")
	private int discount;

	@Column(name = "maxPriceDiscount")
	private double maxPriceDiscount;
	
	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "status")
	private int status;

	@Column(name = "minPrice")
	private double minPrice;

	@JsonIgnore
	@OneToMany(mappedBy = "voucherEntity", fetch = FetchType.LAZY)
	private Set<OrdersDetailsEntity> ordersDetailsEntity;
	
	@OneToMany(mappedBy = "voucherEntity" , fetch = FetchType.LAZY)
	private Set<OrdersEntity> ordersEntity;

	public VoucherEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}

	public String getVoucherName() {
		return voucherName;
	}

	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
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

	public double getMaxPriceDiscount() {
		return maxPriceDiscount;
	}

	public void setMaxPriceDiscount(double maxPriceDiscount) {
		this.maxPriceDiscount = maxPriceDiscount;
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

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public Set<OrdersDetailsEntity> getOrdersDetailsEntity() {
		return ordersDetailsEntity;
	}

	public void setOrdersDetailsEntity(Set<OrdersDetailsEntity> ordersDetailsEntity) {
		this.ordersDetailsEntity = ordersDetailsEntity;
	}

	public Set<OrdersEntity> getOrdersEntity() {
		return ordersEntity;
	}

	public void setOrdersEntity(Set<OrdersEntity> ordersEntity) {
		this.ordersEntity = ordersEntity;
	}
	
	
	

}
