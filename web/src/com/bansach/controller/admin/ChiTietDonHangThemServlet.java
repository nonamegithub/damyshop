package com.bansach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.DonHang;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.DonHangBO;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;

public class ChiTietDonHangThemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietDonHangThemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//lay danh sach don hang
		DonHangBO donHangBO = new DonHangBO();
		ArrayList<DonHang> arrDonHang = donHangBO.getTatCaDonHang();
		request.setAttribute("arrDonHang", arrDonHang);
		
		//lay danh sach san pham
		SanPhamBO sanPhamBO = new SanPhamBO();
		ArrayList<SanPham> arrSanPham = sanPhamBO.getTatCaSanPham();
		request.setAttribute("arrSanPham", arrSanPham);
		
		//forward
		MyUtils.forward(getServletContext(), request, response, "/admin/chi-tiet-don-hang-them.jsp");
	}

}
