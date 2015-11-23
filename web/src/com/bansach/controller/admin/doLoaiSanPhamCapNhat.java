package com.bansach.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.bo.LoaiSanPhamBO;

/**
 * Servlet implementation class doLoaiSanPhamCapNhat
 */
@WebServlet("/doLoaiSanPhamCapNhat")
public class doLoaiSanPhamCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLoaiSanPhamCapNhat() {
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
		
		String maLoaiSP = (String) request.getParameter("maLoaiSP");
		String tenLSP = (String) request.getParameter("tenLSP");
		String moTaLSP = (String) request.getParameter("moTaLSP");
		
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		String errorParse = null;
		LoaiSanPham loaiSanPham =null;
		
		try{
			int maLSP =Integer.parseInt(maLoaiSP);
			loaiSanPham = new LoaiSanPham(maLSP, tenLSP, moTaLSP);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//Cap nhat thanh cong
		if(errorParse==null){
			loaiSanPhamBO.updateLoaiSanPham(loaiSanPham);
			response.sendRedirect(request.getContextPath()+"/admin/loai-san-pham");
		}
		//du lieu nhap vao ko dung
		else
			response.sendRedirect(request.getContextPath()+"/admin/loai-san-pham/cap-nhat?maLoai="+maLoaiSP);
	}
}
