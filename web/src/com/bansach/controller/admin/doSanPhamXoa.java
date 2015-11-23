package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bo.SanPhamBO;

/**
 * Servlet implementation class doSanPhamXoa
 */
@WebServlet("/doSanPhamXoa")
public class doSanPhamXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSanPhamXoa() {
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

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		String maSanPham = request.getParameter("maSanPham");
		
		SanPhamBO sanPhamBO = new SanPhamBO();
		try{
			int maSP = Integer.parseInt(maSanPham);
			sanPhamBO.deleteSanPham(maSP);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/admin/san-pham");
	}
}
