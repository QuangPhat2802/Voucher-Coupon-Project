package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name = "price")
	private double price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_phone", referencedColumnName = "customer_phone")
	private CustomerEntity customerEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "voucher_code", referencedColumnName = "voucher_code")
	private VoucherEntity voucherEntity;

	public OrdersEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
