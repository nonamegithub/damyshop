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

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		// prepare BO
		LoaiSanPhamBO loaiSPBO = new LoaiSanPhamBO();
		SanPhamBO sanPhamBO = new SanPhamBO();
		ArrayList<SanPham> spList = null;
		ArrayList<LoaiSanPham> loaiSPList = null;
		SanPham sp = null;
		
		// get categories list
		loaiSPList = loaiSPBO.getTatCaLoaiSanPham();
		
		// get featured product list
		spList = sanPhamBO.getRandomSanPham(6);
		request.setAttribute("featuredProductList", spList);
		
		// get bestseller product list
		spList = sanPhamBO.getRandomSanPham(6);
		request.setAttribute("bestsellerProductList", spList);
		
		// get bestserller product list left
		spList = sanPhamBO.getRandomSanPham(2);
		request.setAttribute("bestsellerProductListLeft", spList);
		
		// get product selection
		sp = sanPhamBO.getRandomSanPham();
		request.setAttribute("productSelection", sp);
		
		// set attribute
		request.setAttribute("categoriesList", loaiSPList);
		
		MyUtils.forward(getServletContext(), request, response, "/home.jsp");
	}

}
