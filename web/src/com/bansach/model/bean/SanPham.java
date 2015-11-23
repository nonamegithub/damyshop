package com.bansach.model.bean;

import java.math.BigDecimal;

public class SanPham {
	private int maSanPham;
	private int maLoai;
	private String ten;
	private BigDecimal gia;
	private String nhaXuatBan;
	private int trongLuong;
	private String kichThuoc;
	private int soTrang;
	private String moTa;
	private String anh;
	private String tacGia;

	public SanPham() {
	}

	public SanPham(int maLoai, String ten, BigDecimal gia, String nhaXuatBan,
			int trongLuong, String kichThuoc, int soTrang, String moTa,
			String anh, String tacGia) {
		this.maLoai = maLoai;
		this.ten = ten;
		this.gia = gia;
		this.nhaXuatBan = nhaXuatBan;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.soTrang = soTrang;
		this.moTa = moTa;
		this.anh = anh;
		this.tacGia = tacGia;
	}

	public SanPham(int maSanPham, int maLoai, String ten, BigDecimal gia,
			String nhaXuatBan, int trongLuong, String kichThuoc, int soTrang,
			String moTa, String anh, String tacGia) {
		this.maSanPham = maSanPham;
		this.maLoai = maLoai;
		this.ten = ten;
		this.gia = gia;
		this.nhaXuatBan = nhaXuatBan;
		this.trongLuong = trongLuong;
		this.kichThuoc = kichThuoc;
		this.soTrang = soTrang;
		this.moTa = moTa;
		this.anh = anh;
		this.tacGia = tacGia;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public BigDecimal getGia() {
		return gia;
	}

	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getTrongLuong() {
		return trongLuong;
	}

	public void setTrongLuong(int trongLuong) {
		this.trongLuong = trongLuong;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	@Override
	public String toString() {
		return maSanPham + "; " + maLoai + "; " + ten + "; " + gia + "; "
				+ nhaXuatBan + "; " + trongLuong + "; " + kichThuoc + "; "
				+ soTrang + "; " + moTa + "; " + anh + "; " + tacGia;
	}

}
