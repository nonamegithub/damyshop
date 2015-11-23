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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		// set utf-8
		
		// prepare BO, list, object, variables
		SanPhamBO spBO = new SanPhamBO();
		LoaiSanPhamBO loaiSPBO = new LoaiSanPhamBO();
		ArrayList<SanPham> listSP = null;
		ArrayList<LoaiSanPham> listLoaiSP = null;
		
		// get parameters
		String q = request.getParameter("q");
		String opt = request.getParameter("opt");
		
		// get categories list
		listLoaiSP = loaiSPBO.getTatCaLoaiSanPham();
		
		// get bestseller product list left
		listSP = spBO.getRandomSanPham(2);
		request.setAttribute("bestsellerProductListLeft", listSP);
		
		// get list product
		if (opt == null) {
			opt = "default";
		}
		if (q == null) {
			q = "";
		}
		switch (opt) {
		case "t":
			listSP = spBO.getSanPhamTheoTen(q);
			break;
			
		case "tg":
			listSP = spBO.getSanPhamTheoTacGia(q);
			break;
			
		case "mt":
			listSP = spBO.getSanPhamTheoMoTa(q);
			break;
			
		default:
			listSP = spBO.getSanPhamTheoTen(q);
			break;
		}
		
		// set attribute 
		request.setAttribute("categoriesList", listLoaiSP);
		request.setAttribute("productList", listSP);
		request.setAttribute("query", q == null ? "Tất cả" : q);
		 
		// forward
		MyUtils.forward(getServletContext(), request, response, "/search.jsp");
		
	}

}
