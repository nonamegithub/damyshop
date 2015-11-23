package com.bansach.model.bean;

import java.math.BigDecimal;

public class ChiTietGioHang {
	private int maSanPham;
	private String anh;
	private String tenSanPham;
	private int soLuong;
	private BigDecimal gia;

	public ChiTietGioHang(int maSanPham, String anh, String tenSanPham,
			int soLuong, BigDecimal gia) {
		super();
		this.maSanPham = maSanPham;
		this.anh = anh;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return maSanPham + "; " + anh + "; " + tenSanPham + "; " + soLuong
				+ "; " + gia;
	}

}
