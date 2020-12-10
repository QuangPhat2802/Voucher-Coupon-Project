package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_voucher")
public class OrdersDetailsEntity {

	@Id
	@Column(name = "id_CustomerVoucher")
	private int ordersDetailsId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_phone", referencedColumnName = "customer_phone")
	private CustomerEntity customerEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "voucher_code", referencedColumnName = "voucher_code")
	private VoucherEntity voucherEntity;

	public int getOrdersDetailsId() {
		return ordersDetailsId;
	}

	public void setOrdersDetailsId(int ordersDetailsId) {
		this.ordersDetailsId = ordersDetailsId;
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
