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

public class SanPhamCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamCapNhatServlet() {
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
		
		SanPhamBO sanPhamBO = new SanPhamBO();
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		String errorParse = null;
		SanPham sanPham = null;
		String maSanPham = (String) request.getParameter("maSanPham");
		
		try{
			Integer maSP = Integer.parseInt(maSanPham);
			sanPham = sanPhamBO.getSanPhamTheoMa(maSP);
			request.setAttribute("sanPham", sanPham);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//co loi xay ra
		if(errorParse!=null||sanPham==null){
			response.sendRedirect(request.getContextPath()+"/admin/san-pham");
			return;
		}
		
		//Lay danh sach cac loai san pham
		ArrayList<LoaiSanPham> arrLoaiSP = loaiSanPhamBO.getTatCaLoaiSanPham();
		request.setAttribute("arrLoaiSP", arrLoaiSP);
		
		//forward
		MyUtils.forward(getServletContext(), request, response, "/admin/san-pham-cap-nhat.jsp");
	}

}
