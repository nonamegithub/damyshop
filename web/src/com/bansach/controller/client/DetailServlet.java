package com.bansach.controller.client;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;
import com.bansach.utils.Validate;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		ArrayList<SanPham> spList = null;
		SanPham sp = null;
		
		// request parameter(s)
		String maSanPhamStr = request.getParameter("productCode");
		int maSanPhamInt = 0;
		
		if (maSanPhamStr != null && Validate.isNumber(maSanPhamStr)) {
			maSanPhamInt = Integer.parseInt(maSanPhamStr);
		}
		
		// get related product list
		spList = spBO.getRandomSanPham(3);
		request.setAttribute("relatedProductsList", spList);
		
		// get object
		sp = spBO.getSanPhamTheoMa(maSanPhamInt);
		
		// get bestseller product list left
		spList = spBO.getRandomSanPham(2);
		request.setAttribute("bestsellerProductListLeft", spList);
		
		// set attribute
		
		request.setAttribute("sanPham", sp);
		
		// forward
		MyUtils.forward(getServletContext(), request, response, "/detail.jsp");
		
		
	}

}
