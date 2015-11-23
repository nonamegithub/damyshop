package com.bansach.model.bean;

import java.sql.Timestamp;

public class DonHang {
	private int maDonHang;
	private int maKhachHang;
	private Timestamp ngayDat;
	private String ghiChu;
	private String trangThai;

	public DonHang(int maKhachHang, Timestamp ngayDat, String ghiChu,
			String trangThai) {
		super();
		this.maKhachHang = maKhachHang;
		this.ngayDat = ngayDat;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}

	public DonHang(int maDonHang, int maKhachHang, Timestamp ngayDat,
			String ghiChu, String trangThai) {
		this.maDonHang = maDonHang;
		this.maKhachHang = maKhachHang;
		this.ngayDat = ngayDat;
		this.ghiChu = ghiChu;
		this.trangThai = trangThai;
	}

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public int getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Timestamp getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Timestamp ngayDat) {
		this.ngayDat = ngayDat;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return maDonHang + "; " + maKhachHang + "; " + ngayDat + "; " + ghiChu
				+ "; " + trangThai;
	}

}
