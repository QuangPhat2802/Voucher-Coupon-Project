package com.demo.entity;

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
@Table(name = "khach_hang")
public class KhachHangEntity {
	
	
	@Id
	@Column(name = "sdt" , nullable = false)
	private int sdt;
	
	@Column(name = "tenKH" , nullable = false)
	private String name;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "khachhangEntity", fetch = FetchType.LAZY)
//	private Set<VoucherEntity> voucherSet;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "don_hang", joinColumns= {@JoinColumn(name = "sdt", referencedColumnName="sdt")},
	inverseJoinColumns = {@JoinColumn(name = "code",referencedColumnName="code")})
	private Set<VoucherEntity> voucherSet;
	
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

	public Set<VoucherEntity> getVoucherSet() {
		return voucherSet;
	}

	public void setVoucherSet(Set<VoucherEntity> voucherSet) {
		this.voucherSet = voucherSet;
	}
	
	
	
}
