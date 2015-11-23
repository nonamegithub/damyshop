package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.dao.ChiTietDonHangDAO;

public class ChiTietDonHangBO {
	ChiTietDonHangDAO ctdhDAO = new ChiTietDonHangDAO();
	
	public ArrayList<ChiTietDonHang> getTatCaChiTietDonHang() {
		return ctdhDAO.getTatCaChiTietDonHang();
	}
	
	public ArrayList<ChiTietDonHang> getChiTietDonHangTheoMaDonHang(int maDonHang) {
		return ctdhDAO.getChiTietDonHangTheoMaDonHang(maDonHang);
	}
	
	public ChiTietDonHang getChiTietDonHangTheoMa(int maDonHang, int maSanPham) {
		return ctdhDAO.getChiTietDonHangTheoMa(maDonHang, maSanPham);
	}
	
	public int addChiTietDonHang(ChiTietDonHang ctdh) {
		return ctdhDAO.addChiTietDonHang(ctdh);
	}
	
	public int updateChiTietDonHang(ChiTietDonHang ctdh) {
		return ctdhDAO.updateChiTietDonHang(ctdh);
	}
	
	public int deleteChiTietDonHang(int maDonHang, int maSanPham) {
		return ctdhDAO.deleteChiTietDonHang(maDonHang, maSanPham);
	}
}
