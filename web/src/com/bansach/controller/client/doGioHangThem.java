package com.bansach.controller.client;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.utils.MyUtils;
import com.bansach.utils.Validate;

/**
 * Servlet implementation class doGioHangThem
 */
@WebServlet("/doGioHangThem")
public class doGioHangThem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doGioHangThem() {
        super();
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
		// prepare BO, list, object
		ChiTietDonHang ctdh = null;
		
		// request parameters
		String maSanPhamStr = request.getParameter("maSanPham");
		String soLuongStr = request.getParameter("soLuongSp");
		String giaStr = request.getParameter("giaSP");
		
		int maSanPhamInt = 0;
		
		if (maSanPhamStr != null && Validate.isNumber(maSanPhamStr)) {
			maSanPhamInt = Integer.parseInt(maSanPhamStr);
		}
		
		if (maSanPhamInt == 0) {
			// redirect catalog
			response.sendRedirect(request.getContextPath() + "/catalogue?err=Ma_san_pham_khong_hop_le");
			
		} else {
			// add to cart
			ctdh = new ChiTietDonHang(0, maSanPhamInt, BigDecimal.valueOf(Double.parseDouble(giaStr)), Integer.parseInt(soLuongStr));
			MyUtils.themVaoGioHang(request.getSession(), ctdh);
			
			//  redirect shopping cart
			response.sendRedirect(request.getContextPath() + "/cart");
		}
		
		
		
	}

}
