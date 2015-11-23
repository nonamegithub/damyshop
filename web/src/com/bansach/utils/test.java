package com.bansach.utils;

import java.util.ArrayList;

import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.SanPhamBO;

public class test {

	public static void main(String[] args) {
		ArrayList<SanPham> spList = new SanPhamBO().getSanPhamTheoTen("Tony");
		System.out.println("SPLIST.size " + spList.size());
		for (SanPham sp : spList) {
			System.out.println(sp.toString());
		}
	}

}
