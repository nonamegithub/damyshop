package com.bansach.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.DonHang;
import com.bansach.model.bo.DonHangBO;
import com.bansach.utils.DateUtils;

/**
 * Servlet implementation class doDonHangCapNhat
 */
@WebServlet("/doDonHangCapNhat")
public class doDonHangCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDonHangCapNhat() {
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
		
		String maDonHang = (String) request.getParameter("maDonHang");
		String maKhachHang = (String) request.getParameter("maKhachHang");
		String ngayDatHang = (String) request.getParameter("ngayDatHang");
		String ghiChu = (String) request.getParameter("ghiChu");
		String trangThai = (String) request.getParameter("trangThai");
		
		DonHangBO donHangBO = new DonHangBO();
		String errorParse = null;
		DonHang donHang = null;
		
		try{
			Timestamp ngayDat = DateUtils.convertToTimestamp(ngayDatHang);
			int maDH =Integer.parseInt(maDonHang);
			int maKH =Integer.parseInt(maKhachHang);
			donHang = new DonHang(maDH, maKH, ngayDat, ghiChu, trangThai);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//Cap nhat thanh cong
		if(errorParse==null){
			donHangBO.updateDonHang(donHang);
			response.sendRedirect(request.getContextPath()+"/admin/don-hang");
		}
		//du lieu nhap vao ko dung
		else
			response.sendRedirect(request.getContextPath()+"/admin/don-hang/cap-nhat?maDonHang="+maDonHang);
	}

}
