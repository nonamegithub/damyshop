package com.bansach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.DonHang;
import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.ChiTietDonHangBO;
import com.bansach.model.bo.DonHangBO;
import com.bansach.model.bo.KhachHangBO;
import com.bansach.utils.MyUtils;

public class DonHangCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DonHangCapNhatServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		DonHangBO donHangBO = new DonHangBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		ChiTietDonHangBO ctdhBO = new ChiTietDonHangBO();
		
		String maDonHang = (String) request.getParameter("maDonHang");
		String errorParse = null;
		DonHang donHang = null;
		Integer maDH = 0;
		
		try {
			// lay don hang
			maDH = Integer.parseInt(maDonHang);
			donHang = donHangBO.getDonHangTheoMa(maDH);
			request.setAttribute("donHang", donHang);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		// co loi~
		if (errorParse != null || donHang == null) {
			response.sendRedirect(request.getContextPath() + "/admin/don-hang");
			return;
		}

		// lay khach hang
		KhachHang khachHang = khachHangBO.getKhachHangTheoMa(donHang.getMaKhachHang());
		request.setAttribute("KhachHang", khachHang);
		
		// lay chi tiet don hang
		ArrayList<ChiTietDonHang> ctdhList = ctdhBO.getChiTietDonHangTheoMaDonHang(maDH);
		request.setAttribute("ListChiTietDonHang", ctdhList);
		
		// ko co loi
		MyUtils.forward(getServletContext(), request, response, "/admin/don-hang-cap-nhat.jsp");
	}

}
