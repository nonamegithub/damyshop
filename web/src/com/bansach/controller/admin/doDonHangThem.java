package com.bansach.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.DonHang;
import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.DonHangBO;
import com.bansach.model.bo.KhachHangBO;

/**
 * Servlet implementation class doD?nHangThem
 */
@WebServlet("/doDonHangThem")
public class doDonHangThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDonHangThem() {
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
		
		DonHangBO donHangBO = new DonHangBO();
		KhachHangBO khachHangBO = new KhachHangBO();
		Integer maKH = null;
		
		//lay du lieu
		String tenKhachHang = (String) request.getParameter("tenKhachHang");
		String ghiChu = (String) request.getParameter("ghiChu");
		
		//lay ma khach hang tu ten khach hang
		ArrayList<KhachHang> arrKhachHang = khachHangBO.getTatCaKhachHang();
		for( KhachHang khachHang: arrKhachHang ){
			if(tenKhachHang.equals(khachHang.getTen()))
				maKH = khachHang.getMaKhachHang();
		}
		
		//them vao database
		Timestamp ngayDatHang = new Timestamp(System.currentTimeMillis());
		DonHang donHang = new DonHang(maKH, ngayDatHang, ghiChu, "ChuaXem");
		donHangBO.addDonHang(donHang);
		
		//them that bai
		if(maKH==null){
			response.sendRedirect(request.getContextPath()+"/admin/don-hang/them");
			return;
		}
		//Them thanh cong
		response.sendRedirect(request.getContextPath()+"/admin/don-hang");
	}

}
