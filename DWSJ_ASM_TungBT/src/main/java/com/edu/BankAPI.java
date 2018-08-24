package com.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Banking")
public class BankAPI {
	@Autowired
	private BankingBusiness bss;

	@PostMapping("/checkDoiTacExists")
	public boolean checkDoiTacExists(@RequestBody DoiTac dt) {
		return bss.doiTacExists(dt);
	}

	@PostMapping("/doiTacLogin")
	public boolean doiTacLogin(@RequestBody DoiTac dt) {
		return bss.doiTacLogin(dt);
	}

	@PostMapping("/khachHangCheckMaPin")
	public boolean khachHangCheckMaPin(@RequestBody KhachHang kh) {
		return bss.khachHangCheckMaPin(kh);
	}

	@PostMapping("/khachHangLogin")
	public boolean khachHangLogin(@RequestBody KhachHang kh) {
		return bss.khachHangLogin(kh);
	}

	@PostMapping("/getDoiTac/{maDoiTac}")
	public DoiTac getDoiTac(@PathVariable("maDoiTac") String maDT) {
		return bss.getDoiTac(maDT);
	}

	@PostMapping("/getKhachHang/{maKH}")
	public KhachHang getKhachHang(@PathVariable("maKH") String maKH) {
		return bss.getKhachHang(maKH);
	}

	@PostMapping("/checkSoDuKH/{soTien}")
	public boolean checkSoDukhachHang(@RequestBody KhachHang kh, @PathVariable("soTien") Double soTien) {
		return bss.checkSoDu(kh, Double.valueOf(soTien));
	}

	@PostMapping("/giaoDich")
	public boolean giaoDich(@RequestBody LichSuGiaoDich gd) {
		return bss.GiaoDich(gd);
	}

	@PostMapping("/lichSuGiaoDich")
	public List<LichSuGiaoDich> searchLichSu(@RequestBody SearchModel model) {
		return bss.getLichSu(model);
	}
}
