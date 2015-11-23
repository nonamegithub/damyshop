package com.bansach.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.KhachHangBO;

/**
 * Servlet implementation class doKhachHangThem
 */
@WebServlet("/doKhachHangThem")
public class doKhachHangThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doKhachHangThem() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		//lay du lieu
		String ten = (String) request.getParameter("ten");
		String email = (String) request.getParameter("email");
		String soDienThoai = (String) request.getParameter("soDienThoai");
		String ngaySinh = (String) request.getParameter("ngaySinh");
		String diaChi = (String) request.getParameter("diaChi");
		String ghiChu = (String) request.getParameter("ghiChu");
		
		//them vao database
		KhachHangBO khachHangBO = new KhachHangBO();
		KhachHang khachHang = new KhachHang(ten, email, soDienThoai, ngaySinh, diaChi, ghiChu);
		khachHangBO.addKhachHang(khachHang);
		//Them thanh cong
		response.sendRedirect(request.getContextPath()+"/admin/khach-hang");
	}

}
