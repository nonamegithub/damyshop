package com.bansach.controller.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.ChiTietDonHangBO;
import com.bansach.model.bo.SanPhamBO;

/**
 * Servlet implementation class doChiTietDonHangThem
 */
@WebServlet("/doChiTietDonHangThem")
public class doChiTietDonHangThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doChiTietDonHangThem() {
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
		String maDonHang = (String) request.getParameter("maDonHang");
		String tenSanPham = (String) request.getParameter("tenSanPham");
		String soLuong = (String) request.getParameter("soLuong");
		
		ChiTietDonHangBO chiTietDonHangBO = new ChiTietDonHangBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		String error = null;
		Integer maDH =null;
		Integer maSP = null;
		Integer SL=null;
		BigDecimal giaSP = new BigDecimal("0");
		
		//lay ma sp tu ten san pham
		ArrayList<SanPham> arrSanPham = sanPhamBO.getTatCaSanPham();
		for(SanPham sanPham: arrSanPham){
			if(tenSanPham.equals(sanPham.getTen()))
				maSP = sanPham.getMaSanPham();
		}
		
		//chuyen doi du lieu cap nhat
		try{
			maDH = Integer.parseInt(maDonHang);
			SL = Integer.parseInt(soLuong);
			giaSP = sanPhamBO.getSanPhamTheoMa(maSP).getGia(); 
		}catch(NumberFormatException e){
			e.printStackTrace();
			error = e.getMessage();
		}
		//cap nhat that bai
		if(error!=null){
			response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang/them");
			return;
		}
		
		//cap nhat thanh cong
		ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maDH, maSP, giaSP, SL); 
		chiTietDonHangBO.addChiTietDonHang(chiTietDonHang);
		response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang");
	}

}
