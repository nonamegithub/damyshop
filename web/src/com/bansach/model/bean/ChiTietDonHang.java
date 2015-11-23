package com.bansach.model.bean;

import java.math.BigDecimal;

public class ChiTietDonHang {
	private int maDonHang;
	private int maSanPham;
	private BigDecimal gia;
	private int soLuong;

	public ChiTietDonHang(int maDonHang, int maSanPham, BigDecimal gia,
			int soLuong) {
		this.maDonHang = maDonHang;
		this.maSanPham = maSanPham;
		this.gia = gia;
		this.soLuong = soLuong;
	}

	public int getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return maDonHang + "; " + maSanPham + "; " + gia + "; " + soLuong;
	}

}
