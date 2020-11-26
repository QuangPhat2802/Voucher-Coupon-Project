package com.demo.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "voucher_project")
public class VoucherEntity {

	@Id
	@Column(name = "code" , nullable = false)
	private String code;
	
	@Column(name = "name" , nullable = false)
	private String name;
	
	@Column(name = "description" , nullable = false)
	private String description;
	
	@Column(name = "quantity" , nullable = false)
	private int quantity;
	
	@Column(name = "discount" , nullable = false)
	private int discount;
	
	@Column(name = "startDate" , nullable = false)
	private Date startDate;
	
	@Column(name = "endDate" , nullable = false)
	private Date endDate;
	
	@Column(name = "status" , nullable = false)
	private int status;
	
//	@JoinColumn(name = "code", referencedColumnName = "code")
//	@ManyToOne(fetch = FetchType.EAGER)
//	private KhachHangEntity khachhangEntity;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "don_hang", joinColumns= {@JoinColumn(name = "code", referencedColumnName="code")},
	inverseJoinColumns = {@JoinColumn(name = "sdt",referencedColumnName="sdt")})
	private Set<KhachHangEntity> khachhangEntity;
	
	
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


	public Set<KhachHangEntity> getKhachhangEntity() {
		return khachhangEntity;
	}


	public void setKhachhangEntity(Set<KhachHangEntity> khachhangEntity) {
		this.khachhangEntity = khachhangEntity;
	}


//	public KhachHangEntity getKhachhangEntity() {
//		return khachhangEntity;
//	}
//
//
//	public void setKhachhangEntity(KhachHangEntity khachhangEntity) {
//		this.khachhangEntity = khachhangEntity;
//	}
	
}
