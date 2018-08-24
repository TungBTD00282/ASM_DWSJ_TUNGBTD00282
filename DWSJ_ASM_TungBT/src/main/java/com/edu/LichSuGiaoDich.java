package com.edu;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "LichSuGiaoDich")
public class LichSuGiaoDich {
	private int id;
	private String maDoiTac;
	private String maKhachHang;
	private String maDonHang;
	private Double soTien;
	private Double phi;
	private Date ngayChuyenTien;

	public LichSuGiaoDich() {
		super();
	}

	public LichSuGiaoDich(int id, String maDoiTac, String maKhachHang, String maDonHang, Double soTien,
			Date ngayChuyenTien) {
		super();
		this.id = id;
		this.maDoiTac = maDoiTac;
		this.maKhachHang = maKhachHang;
		this.maDonHang = maDonHang;
		this.soTien = soTien;
		this.ngayChuyenTien = ngayChuyenTien;
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

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Double getSoTien() {
		return soTien;
	}

	public void setSoTien(Double soTien) {
		this.soTien = soTien;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getNgayChuyenTien() {
		return ngayChuyenTien;
	}

	public void setNgayChuyenTien(Date ngayChuyenTien) {
		this.ngayChuyenTien = ngayChuyenTien;
	}

	public Double getPhi() {
		return phi;
	}

	public void setPhi(Double phi) {
		this.phi = phi;
	}

}
