package com.bansach.controller.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.ChiTietGioHang;
import com.bansach.model.bean.GioHang;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
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
		// prepare BO, list, object
		SanPhamBO spBO = new SanPhamBO();
		ArrayList<ChiTietGioHang> ctGioHangList = new ArrayList<ChiTietGioHang>();
		ArrayList<SanPham> spList = null;
		SanPham sp = null;
		ChiTietGioHang ctGioHang = null;
		BigDecimal total = new BigDecimal(0);
		
		// get GioHang from session
		GioHang gioHang = MyUtils.getGioHang(request.getSession());
		
		if (gioHang != null) {
			ArrayList<ChiTietDonHang> c = gioHang.getListSanPham();
			for (ChiTietDonHang ctdh : c) {
				sp = spBO.getSanPhamTheoMa(ctdh.getMaSanPham());
				ctGioHang = new ChiTietGioHang(sp.getMaSanPham(), sp.getAnh(), sp.getTen(), ctdh.getSoLuong(), sp.getGia());
				ctGioHangList.add(ctGioHang);
				
				// total
				total = total.add(sp.getGia().multiply(BigDecimal.valueOf(ctdh.getSoLuong())));
			}
		}
		
		// set attribute
		request.setAttribute("ChiTietGioHangList", ctGioHangList);
		request.setAttribute("total", total);
		
		// get bestseller product list left
		spList = spBO.getRandomSanPham(1);
		request.setAttribute("bestsellerProductListLeft", spList);
		
		// forward
		MyUtils.forward(getServletContext(), request, response, "/checkout.jsp");
		
	}

}
