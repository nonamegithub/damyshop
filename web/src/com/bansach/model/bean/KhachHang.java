package com.bansach.model.bean;

public class KhachHang {
	private int maKhachHang;
	private String ten;
	private String email;
	private String soDienThoai;
	private String ngaySinh;
	private String diaChi;
	private String ghiChu;

	public KhachHang() {
		
	}
	
	public KhachHang(String ten, String email, String soDienThoai,
			String ngaySinh, String diaChi, String ghiChu) {
		this.ten = ten;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
	}

	public KhachHang(int maKhachHang, String ten, String email,
			String soDienThoai, String ngaySinh, String diaChi, String ghiChu) {
		this.maKhachHang = maKhachHang;
		this.ten = ten;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return maKhachHang + "; " + ten + "; " + email + "; " + soDienThoai
				+ "; " + ngaySinh + "; " + diaChi + "; " + ghiChu;
	}

}
