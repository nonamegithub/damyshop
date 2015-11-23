package com.bansach.model.bean;

import java.util.ArrayList;

public class GioHang {
	private ArrayList<ChiTietDonHang> listSanPham;

	public GioHang() {
		this.listSanPham = new ArrayList<ChiTietDonHang>();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ChiTietDonHang> getListSanPham() {
		return (ArrayList<ChiTietDonHang>) listSanPham.clone();
	}

	public void themHang(ChiTietDonHang ctdh) {
		this.listSanPham.add(ctdh);
	}

	public void xoaHang(ChiTietDonHang ctdh) {
		this.listSanPham.remove(ctdh);
	}

}
