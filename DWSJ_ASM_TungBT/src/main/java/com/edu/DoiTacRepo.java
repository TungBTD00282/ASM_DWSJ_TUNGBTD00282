package com.edu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoiTacRepo extends JpaRepository<DoiTac, Integer>{
	Optional<DoiTac> findByMaDoiTac(String maDoiTac);
}
