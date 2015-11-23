package com.bansach.model.bean;

public class LoaiSanPham {
	private int maLoai;
	private String ten;
	private String moTa;

	public LoaiSanPham(String ten, String moTa) {
		this.ten = ten;
		this.moTa = moTa;
	}

	public LoaiSanPham(int maLoai, String ten, String moTa) {
		this.maLoai = maLoai;
		this.ten = ten;
		this.moTa = moTa;
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

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return maLoai + "; " + ten + "; " + moTa;
	}

}
