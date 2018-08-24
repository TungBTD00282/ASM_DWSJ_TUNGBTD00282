package com.edu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepo extends JpaRepository<KhachHang, Integer>{
	Optional<KhachHang> findByMaKhachHang(String ma);
}
