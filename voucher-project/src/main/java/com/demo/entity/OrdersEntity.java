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
@Table(name = "orders")
public class OrdersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orders_ID", nullable = false)
	private int ordersID;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_phone", referencedColumnName = "customer_phone")
	private CustomerEntity customerEntity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "voucher_code", referencedColumnName = "voucher_code")
	private VoucherEntity voucherEntity;

	@Column(name = "price")
	private double minPrice;

	public OrdersEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getOrdersID() {
		return ordersID;
	}

	public OrdersEntity(int ordersID, CustomerEntity customerEntity, VoucherEntity voucherEntity, double minPrice) {
		this.ordersID = ordersID;
		this.customerEntity = customerEntity;
		this.voucherEntity = voucherEntity;
		this.minPrice = minPrice;
	}

	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	public VoucherEntity getVoucherEntity() {
		return voucherEntity;
	}

	public void setVoucherEntity(VoucherEntity voucherEntity) {
		this.voucherEntity = voucherEntity;
	}

}
