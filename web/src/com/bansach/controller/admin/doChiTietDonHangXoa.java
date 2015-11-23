package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bo.ChiTietDonHangBO;

/**
 * Servlet implementation class doChiTietDonHangXoa
 */
@WebServlet("/doChiTietDonHangXoa")
public class doChiTietDonHangXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doChiTietDonHangXoa() {
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
		
		String maDonHang = request.getParameter("maDonHang");
		String maSanPham = request.getParameter("maSanPham");
		
		ChiTietDonHangBO chiTietDonHangBO = new ChiTietDonHangBO();
		try{
			int maDH = Integer.parseInt(maDonHang);
			int maSP = Integer.parseInt(maSanPham);
			chiTietDonHangBO.deleteChiTietDonHang(maDH, maSP);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/admin/chi-tiet-don-hang");
	}

}
