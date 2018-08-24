package com.edu;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KhachHang")
public class KhachHang {
	private int id;
	private String maKhachHang;
	private String matKhau;
	private String maPin;
	private Double soDu;

	public KhachHang() {
		super();
	}

	public KhachHang(int id, String maKhachHang, String matKhau, String maPin, Double soDu) {
		super();
		this.id = id;
		this.maKhachHang = maKhachHang;
		this.matKhau = matKhau;
		this.maPin = maPin;
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

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getMaPin() {
		return maPin;
	}

	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}

	public Double getSoDu() {
		return soDu;
	}

	public void setSoDu(Double soDu) {
		this.soDu = soDu;
	}

}
