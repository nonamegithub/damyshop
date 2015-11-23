package com.bansach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.ChiTietDonHangBO;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;

public class ChiTietDonHangDanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChiTietDonHangDanhSachServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//danh sach chi tiet don hang
		ChiTietDonHangBO chiTietDonHangBO = new ChiTietDonHangBO();
		ArrayList<ChiTietDonHang> arrChiTietDonHang = chiTietDonHangBO.getTatCaChiTietDonHang();
		request.setAttribute("arrChiTietDonHang", arrChiTietDonHang);
		
		//danh sach san pham
		SanPhamBO sanPhamBO = new SanPhamBO();
		ArrayList<SanPham> arrSanPham = sanPhamBO.getTatCaSanPham();
		request.setAttribute("arrSanPham", arrSanPham);
		
		//forward
		MyUtils.forward(getServletContext(), request, response, "/admin/chi-tiet-don-hang-danh-sach.jsp");
	}

}
