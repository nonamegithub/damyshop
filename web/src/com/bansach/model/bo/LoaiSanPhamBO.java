package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.dao.LoaiSanPhamDAO;

public class LoaiSanPhamBO {
	LoaiSanPhamDAO loaiSPDAO = new LoaiSanPhamDAO();
	
	public ArrayList<LoaiSanPham> getTatCaLoaiSanPham() {
		return loaiSPDAO.getTatCaLoaiSanPham();
	}
	
	public LoaiSanPham getLoaiSanPhamTheoMa(int maLoaiSanPham) {
		return loaiSPDAO.getLoaiSanPhamTheoMa(maLoaiSanPham);
	}
	
	public int addLoaiSanPham(LoaiSanPham lsp) {
		return loaiSPDAO.addLoaiSanPham(lsp);
	}
	
	public int updateLoaiSanPham(LoaiSanPham lsp) {
		return loaiSPDAO.updateLoaiSanPham(lsp);
	}
	
	public int deleteLoaiSanPham(int maLoaiSanPham) {
		return loaiSPDAO.deleteLoaiSanPham(maLoaiSanPham);
	}
	
}
