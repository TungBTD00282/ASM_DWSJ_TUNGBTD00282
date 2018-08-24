package com.edu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DoiTac")
public class DoiTac {
	private int id;
	private String maDoiTac;
	private String matKhau;
	private String tenDoiTac;
	private Double soDu;

	public DoiTac() {
		super();
	}

	public DoiTac(int id, String maDoiTac, String matKhau, String tenDoiTac, Double soDu) {
		super();
		this.id = id;
		this.maDoiTac = maDoiTac;
		this.matKhau = matKhau;
		this.tenDoiTac = tenDoiTac;
		this.soDu = soDu;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDoiTac() {
		return maDoiTac;
	}

	public void setMaDoiTac(String maDoiTac) {
		this.maDoiTac = maDoiTac;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenDoiTac() {
		return tenDoiTac;
	}

	public void setTenDoiTac(String tenDoiTac) {
		this.tenDoiTac = tenDoiTac;
	}

	public Double getSoDu() {
		return soDu;
	}

	public void setSoDu(Double soDu) {
		this.soDu = soDu;
	}

}
