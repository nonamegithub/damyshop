package com.bansach.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.bo.LoaiSanPhamBO;
import com.bansach.utils.MyUtils;

public class LoaiSanPhamCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoaiSanPhamCapNhatServlet() {
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
		
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		String maLoai = (String) request.getParameter("maLoai");
		String errorParse = null;
		LoaiSanPham loaiSanPham = null;
		try{
			Integer maLSP = Integer.parseInt(maLoai);
			loaiSanPham = loaiSanPhamBO.getLoaiSanPhamTheoMa(maLSP);
			request.setAttribute("loaiSanPham", loaiSanPham);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		if(errorParse!=null||loaiSanPham==null){
			response.sendRedirect(request.getContextPath()+"/admin/loai-san-pham");
			return;
		}
		MyUtils.forward(getServletContext(), request, response, "/admin/loai-san-pham-cap-nhat.jsp");
	}

}
