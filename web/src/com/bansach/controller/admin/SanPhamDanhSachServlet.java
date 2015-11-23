package com.bansach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.LoaiSanPhamBO;
import com.bansach.model.bo.SanPhamBO;
import com.bansach.utils.MyUtils;

public class SanPhamDanhSachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamDanhSachServlet() {
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
		
		//Lay danh sach san pham
		SanPhamBO sanPhamBO = new SanPhamBO();
		ArrayList<SanPham> arrSanPham = sanPhamBO.getTatCaSanPham();
		request.setAttribute("arrSanPham", arrSanPham);
		
		//Lay danh sach loai san pham 
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		ArrayList<LoaiSanPham> arrLoaiSP = loaiSanPhamBO.getTatCaLoaiSanPham();
		request.setAttribute("arrLoaiSP", arrLoaiSP);

		//forward
		MyUtils.forward(getServletContext(), request, response, "/admin/san-pham-danh-sach.jsp");
	}

}
