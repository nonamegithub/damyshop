package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.SanPham;
import com.bansach.model.dao.SanPhamDAO;

public class SanPhamBO {
	SanPhamDAO spDAO = new SanPhamDAO();
	
	public ArrayList<SanPham> getTatCaSanPham() {
		return spDAO.getTatCaSanPham();
	}
	
	public ArrayList<SanPham> getSanPhamTheoLoai(int maLoai) {
		return spDAO.getSanPhamTheoLoai(maLoai);
	}
	
	public ArrayList<SanPham> getSanPhamTheoTen(String ten) {
		return spDAO.getSanPhamTheoTen(ten);
	}
	
	public ArrayList<SanPham> getTopSanPham(int soDong) {
		return spDAO.getTopSanPham(soDong);
	}
	
	public ArrayList<SanPham> getRandomSanPham(int soDong) {
		return spDAO.getRandomSanPham(soDong);
	}
	
	public SanPham getSanPhamTheoMa(int maSanPham) {
		return spDAO.getSanPhamTheoMa(maSanPham);
	}
	
	public ArrayList<SanPham> getTopSanPhamTheoLoai(int maLoai, int soDong) {
		return spDAO.getTopSanPhamTheoLoai(maLoai, soDong);
	}
	
	public int addSanPham(SanPham sp) {
		return spDAO.addSanPham(sp);
	}
	
	public int updateSanPham(SanPham sp) {
		return spDAO.updateSanPham(sp);
	}
	
	public int deleteSanPham(int maSanPham) {
		return spDAO.deleteSanPham(maSanPham);
	}

	public ArrayList<SanPham> getSanPhamTheoTacGia(String tacGia) {
		return spDAO.getSanPhamTheoTacGia(tacGia);
	}

	public ArrayList<SanPham> getSanPhamTheoMoTa(String moTa) {
		return spDAO.getSanPhamTheoMoTa(moTa);
	}

	public SanPham getRandomSanPham() {
		return spDAO.getRandomSanPham();
	}
	
}
