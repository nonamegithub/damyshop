package com.bansach.controller.client;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.LoaiSanPhamBO;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;
import com.bansach.utils.Validate;

/**
 * Servlet implementation class CatalogueServlet
 */
@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogueServlet() {
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
		LoaiSanPhamBO loaiSPBO = new LoaiSanPhamBO();
		SanPhamBO spBO = new SanPhamBO();
		ArrayList<LoaiSanPham> loaiSPList = null;
		ArrayList<SanPham> spList = null;
		LoaiSanPham loaiSP = null;
		String tenLoai = null;
		
		// request parameters
		String maLoaiStr = request.getParameter("ctgCode");
		int maLoaiInt = 0;
		
		if (maLoaiStr != null && Validate.isNumber(maLoaiStr)) {
			maLoaiInt = Integer.parseInt(maLoaiStr);
		}
		
		// get categories list
		loaiSPList = loaiSPBO.getTatCaLoaiSanPham();
		
		// get bestseller product list left
		spList = spBO.getRandomSanPham(2);
		request.setAttribute("bestsellerProductListLeft", spList);
		
		// get products list
		if (maLoaiInt == 0) {
			spList = spBO.getTatCaSanPham();
			tenLoai = "Tất Cả";
		} else {
			spList = spBO.getSanPhamTheoLoai(maLoaiInt);
			loaiSP = loaiSPBO.getLoaiSanPhamTheoMa(maLoaiInt);
			tenLoai = loaiSP.getTen();
		}
		
		// set attribute 
		request.setAttribute("categoriesList", loaiSPList);
		request.setAttribute("productList", spList);
		request.setAttribute("tenLoai", tenLoai);
		
		// forward
		MyUtils.forward(getServletContext(), request, response, "/catalogue.jsp");
		
	}

}
