package com.edu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LichSuRepo extends JpaRepository<LichSuGiaoDich, Integer>{
	List<LichSuGiaoDich> findByMaDoiTac(String maDT);
	List<LichSuGiaoDich> findByMaKhachHang (String maKH);
}
