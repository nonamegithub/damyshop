package com.bansach.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.utils.MyUtils;
import com.bansach.utils.Validate;

/**
 * Servlet implementation class doGioHangXoa
 */
@WebServlet("/doGioHangXoa")
public class doGioHangXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doGioHangXoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request maSanPham
		String maSanPhamStr = request.getParameter("productCode");
		int maSanPhamInt = 0;
		
		if (maSanPhamStr != null && Validate.isNumber(maSanPhamStr)) {
			maSanPhamInt = Integer.parseInt(maSanPhamStr);
			
			// delete from session
			MyUtils.xoaKhoiGioHang(request.getSession(), maSanPhamInt);
			
			// redirect
			response.sendRedirect(request.getContextPath() + "/cart");
			
		} else {
			// error: maSanPham invalid
			// redirect 
			response.sendRedirect(request.getContextPath() + "/cart?err=Loi");
		}
		
	}

}
