package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.DonHang;
import com.bansach.model.dao.DonHangDAO;

public class DonHangBO {
	DonHangDAO dhDAO = new DonHangDAO();

	public ArrayList<DonHang> getTatCaDonHang() {
		return dhDAO.getTatCaDonHang();
	}
	
	public ArrayList<DonHang> getDonHangChuaXem() {
		return dhDAO.getDonHangChuaXem();
	}

	public DonHang getDonHangTheoMa(int maDonHang) {
		return dhDAO.getDonHangTheoMa(maDonHang);
	}

	public int addDonHang(DonHang dh) {
		return dhDAO.addDonHang(dh);
	}

	public int updateDonHang(DonHang dh) {
		return dhDAO.updateDonHang(dh);
	}

	public int deleteDonHang(int maDonHang) {
		return dhDAO.deleteDonHang(maDonHang);
	}

}
