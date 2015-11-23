package com.bansach.model.bo;

import java.util.ArrayList;

import com.bansach.model.bean.NhanVien;
import com.bansach.model.dao.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nvDAO = new NhanVienDAO();

	public ArrayList<NhanVien> getTatCaNhanVien() {
		return nvDAO.getTatCaNhanVien();
	}

	public NhanVien getNhanVienTheoMa(int maNhanVien) {
		return nvDAO.getNhanVienTheoMa(maNhanVien);
	}

	public NhanVien getNhanVienTheoTenDangNhapVaMatKhau(String tenDangNhap,
			String matKhau) {
		return nvDAO.getNhanVienTheoTenDangNhapVaMatKhau(tenDangNhap, matKhau);
	}

	public int addNhanVien(NhanVien nv) {
		return nvDAO.addNhanVien(nv);
	}

	public int updateNhanVien(NhanVien nv) {
		return nvDAO.updateNhanVien(nv);
	}

	public int deleteNhanVien(int maNhanVien) {
		return nvDAO.deleteNhanVien(maNhanVien);
	}

}
