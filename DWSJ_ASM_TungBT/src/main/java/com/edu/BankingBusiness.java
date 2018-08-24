package com.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingBusiness {
	@Autowired
	DoiTacRepo doiTacRepo;
	@Autowired
	KhachHangRepo khachHangRepo;
	@Autowired
	LichSuRepo lichSuRepo;

	public boolean doiTacExists(DoiTac doiTac) {
		return doiTacRepo.findByMaDoiTac(doiTac.getMaDoiTac()).isPresent();
	}

	public DoiTac getDoiTac(String maDoiTac) {
		Optional<DoiTac> op = doiTacRepo.findByMaDoiTac(maDoiTac);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public KhachHang getKhachHang(String ma) {
		Optional<KhachHang> op = khachHangRepo.findByMaKhachHang(ma);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public boolean doiTacLogin(DoiTac doitac) {
		Optional<DoiTac> op = doiTacRepo.findByMaDoiTac(doitac.getMaDoiTac());
		if (op.isPresent()) {
			if (op.get().getMatKhau().equalsIgnoreCase(doitac.getMatKhau())) {
				return true;
			}
		}
		return false;
	}

	public boolean khachHangLogin(KhachHang kh) {
		Optional<KhachHang> op = khachHangRepo.findByMaKhachHang(kh.getMaKhachHang());
		if (op.isPresent()) {
			if (op.get().getMatKhau().equalsIgnoreCase(kh.getMatKhau())) {
				return true;
			}
		}
		return false;
	}

	public boolean khachHangCheckMaPin(KhachHang kh) {
		Optional<KhachHang> op = khachHangRepo.findByMaKhachHang(kh.getMaKhachHang());
		if (op.isPresent()) {
			if (op.get().getMaPin().equalsIgnoreCase(kh.getMaPin())) {
				return true;
			}
		}
		return false;
	}

	public boolean checkSoDu(KhachHang kh, Double soTien) {
		Optional<KhachHang> op = khachHangRepo.findByMaKhachHang(kh.getMaKhachHang());
		if (op.isPresent()) {
			if (op.get().getSoDu() > soTien) {
				return true;
			}
		}
		return false;
	}

	public boolean GiaoDich(LichSuGiaoDich gd) {
		// tinhPhi
		DoiTac dt = doiTacRepo.findByMaDoiTac(gd.getMaDoiTac()).get();
		KhachHang kh = khachHangRepo.findByMaKhachHang(gd.getMaKhachHang()).get();

		// Cong Tien
		dt.setSoDu(dt.getSoDu() + gd.getSoTien() - tinhPhi(gd.getSoTien()));
		doiTacRepo.save(dt);

		// Tru Tien
		kh.setSoDu(kh.getSoDu() - gd.getSoTien());
		khachHangRepo.save(kh);

		// GhiLichSu
		gd.setPhi(tinhPhi(gd.getSoTien()));
		gd.setNgayChuyenTien(new Date());
		lichSuRepo.save(gd);

		return true;
	}

	public List<LichSuGiaoDich> getLichSu(SearchModel searchForm) {
		List<LichSuGiaoDich> all = new ArrayList<>();
		if (searchForm.getType() == 1) {
			all = lichSuRepo.findByMaDoiTac(searchForm.getMa());
		} else {
			all = lichSuRepo.findByMaKhachHang(searchForm.getMa());
		}
		if (null != searchForm.getFromDate() || null != searchForm.getToDate()) {
			List<LichSuGiaoDich> fillter = new ArrayList<>();
			if (null != searchForm.getFromDate() && null == searchForm.getToDate()) {
				for (LichSuGiaoDich ls : all) {
					if (ls.getNgayChuyenTien().after(searchForm.getFromDate())) {
						fillter.add(ls);
					}
				}
			}

			if (null != searchForm.getToDate() && null == searchForm.getFromDate()) {
				for (LichSuGiaoDich ls : all) {
					if (ls.getNgayChuyenTien().before(searchForm.getToDate())) {
						fillter.add(ls);
					}
				}
			}

			if (null != searchForm.getToDate() && null != searchForm.getFromDate()) {
				for (LichSuGiaoDich ls : all) {
					if (ls.getNgayChuyenTien().after(searchForm.getFromDate())
							&& ls.getNgayChuyenTien().before(searchForm.getToDate())) {
						fillter.add(ls);
					}
				}
			}
			return fillter;
		} else {
			return all;
		}
	}

	private Double tinhPhi(Double soTien) {
		Double phi = Double.valueOf(0);
		if (soTien <= 100000) {
			phi = Double.valueOf(10000);
		} else if (soTien > 100000 && soTien <= 500000) {
			phi = soTien * 0.02;
		} else if (soTien > 500000 && soTien <= 1000000) {
			phi = soTien * 0.015;
		} else if (soTien > 1000000 && soTien <= 5000000) {
			phi = soTien * 0.01;
		} else if (soTien > 1000000 && soTien <= 5000000) {
			phi = soTien * 0.01;
		} else if (soTien > 5000000) {
			phi = soTien * 0.005;
		}
		return phi;
	}

}
