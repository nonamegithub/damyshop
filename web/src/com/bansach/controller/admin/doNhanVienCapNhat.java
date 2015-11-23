package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.NhanVien;
import com.bansach.model.bo.NhanVienBO;

/**
 * Servlet implementation class doNhanVienCapNhat
 */
@WebServlet("/doNhanVienCapNhat")
public class doNhanVienCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doNhanVienCapNhat() {
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
		
		String maNhanVien = (String) request.getParameter("maNhanVien");
		String ten = (String) request.getParameter("ten");
		String tenDangNhap = (String) request.getParameter("tenDangNhap");
		String matKhau = (String) request.getParameter("matKhau");
		String ghiChu = (String) request.getParameter("ghiChu");
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		String errorParse = null;
		NhanVien nhanVien =null;
		
		try{
			int maNV =Integer.parseInt(maNhanVien);
			nhanVien = new NhanVien(maNV, ten, tenDangNhap, matKhau, ghiChu);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//Cap nhat thanh cong
		if(errorParse==null){
			nhanVienBO.updateNhanVien(nhanVien);
			response.sendRedirect(request.getContextPath()+"/admin/nhan-vien");
		}
		//du lieu nhap vao ko dung
		else
			response.sendRedirect(request.getContextPath()+"/admin/nhan-vien/cap-nhat?maNhanVien="+maNhanVien);
	}

}
