package com.bansach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.DonHang;
import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.DonHangBO;
import com.bansach.model.bo.KhachHangBO;
import com.bansach.utils.MyUtils;

public class HomeAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeAdminServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		DonHangBO donHangBO = new DonHangBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		
		//lay danh sach don hang
		ArrayList<DonHang> arrayDonHang = donHangBO.getDonHangChuaXem();
		request.setAttribute("arrayDonHang", arrayDonHang);
		
		//lay danh sach khach hang
		ArrayList<KhachHang> arrayKhachHang = khachHangBO.getTatCaKhachHang();
		request.setAttribute("arrayKhachHang", arrayKhachHang);
		
		
		MyUtils.forward(getServletContext(), request, response, "/admin/home-admin.jsp");
		
	}

}
