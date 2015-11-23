package com.bansach.model.bean;

public class NhanVien {
	private int maNhanVien;
	private String ten;
	private String tenDangNhap;
	private String matKhau;
	private String ghiChu;

	public NhanVien(String ten, String tenDangNhap, String matKhau,
			String ghiChu) {
		this.ten = ten;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.ghiChu = ghiChu;
	}

	public NhanVien(int maNhanVien, String ten, String tenDangNhap,
			String matKhau, String ghiChu) {
		this.maNhanVien = maNhanVien;
		this.ten = ten;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.ghiChu = ghiChu;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return maNhanVien + "; " + ten + "; " + tenDangNhap + "; " + matKhau
				+ "; " + ghiChu;
	}

}
