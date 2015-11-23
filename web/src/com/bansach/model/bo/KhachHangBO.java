package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.KhachHang;
import com.bansach.model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khDAO = new KhachHangDAO();

	public ArrayList<KhachHang> getTatCaKhachHang() {
		return khDAO.getTatCaKhachHang();
	}

	public KhachHang getKhachHangTheoMa(int maKhacHang) {
		return khDAO.getKhachHangTheoMa(maKhacHang);
	}

	public int addKhachHang(KhachHang kh) {
		return khDAO.addKhachHang(kh);
	}

	public int updateKhachHang(KhachHang kh) {
		return khDAO.updateKhachHang(kh);
	}

	public int deleteKhachHang(int maKhachHang) {
		return khDAO.deleteKhachHang(maKhachHang);
	}

}
