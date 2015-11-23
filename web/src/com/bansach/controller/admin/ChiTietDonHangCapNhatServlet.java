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

public class ChiTietDonHangCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChiTietDonHangCapNhatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		ChiTietDonHangBO chiTietDonHangBO = new ChiTietDonHangBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		String maDonHang = (String) request.getParameter("maDonHang");
		String maSanPham = (String) request.getParameter("maSanPham");
		
		String errorParse = null;
		ChiTietDonHang chiTietDonHang= null;
		
		//lay chi tiet don hang tu ma don hang va ma san pham
		try{
			Integer maDH = Integer.parseInt(maDonHang);
			Integer maSP = Integer.parseInt(maSanPham);
			chiTietDonHang = chiTietDonHangBO.getChiTietDonHangTheoMa(maDH, maSP);
			request.setAttribute("chiTietDonHang", chiTietDonHang);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//khong lay duoc chi tiet don hang
		if(errorParse!=null||chiTietDonHang==null){
			response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang");
			return;
		}
		
		//thanh cong -> forward
		//lay danh sach san pham
		ArrayList<SanPham> arrSanPham = sanPhamBO.getTatCaSanPham();
		request.setAttribute("arrSanPham", arrSanPham);
		
		MyUtils.forward(getServletContext(), request, response, "/admin/chi-tiet-don-hang-cap-nhat.jsp");
	}

}
