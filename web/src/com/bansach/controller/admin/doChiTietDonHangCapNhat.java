package com.bansach.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bo.ChiTietDonHangBO;

/**
 * Servlet implementation class doChiTietDonHangCapNhat
 */
@WebServlet("/doChiTietDonHangCapNhat")
public class doChiTietDonHangCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doChiTietDonHangCapNhat() {
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
		String maSanPham = (String) request.getParameter("maSanPham");
		String gia = (String) request.getParameter("gia");
		String soLuong = (String) request.getParameter("soLuong");
		
		ChiTietDonHangBO chiTietDonHangBO = new ChiTietDonHangBO();
		String errorParse = null;
		ChiTietDonHang chiTietDonHang = null;
		
		try{
			int maDH =Integer.parseInt(maDonHang);
			int maSP =Integer.parseInt(maSanPham);
			BigDecimal giaSP = BigDecimal.valueOf((double)Double.parseDouble(gia));
			int SL = Integer.parseInt(soLuong);
			chiTietDonHang = new ChiTietDonHang(maDH, maSP, giaSP, SL);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//Cap nhat thanh cong
		if(errorParse==null){
			chiTietDonHangBO.updateChiTietDonHang(chiTietDonHang);
			response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang");
		}
		//du lieu nhap vao ko dung
		else
			response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang/cap-nhat?maDonHang="+maDonHang+"&maSanPham="+maSanPham);
	}

}
