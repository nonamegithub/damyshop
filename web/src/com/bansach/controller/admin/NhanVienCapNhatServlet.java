package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.NhanVien;
import com.bansach.model.bo.NhanVienBO;
import com.bansach.utils.MyUtils;

public class NhanVienCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienCapNhatServlet() {
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
		
		NhanVienBO nhanVienBO = new NhanVienBO();
		String maNhanVien = (String) request.getParameter("maNhanVien");
		String errorParse = null;
		NhanVien nhanVien = null;
		try{
			Integer maNV = Integer.parseInt(maNhanVien);
			nhanVien = nhanVienBO.getNhanVienTheoMa(maNV);
			request.setAttribute("nhanVien", nhanVien);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		if(errorParse!=null||nhanVien==null){
			response.sendRedirect(request.getContextPath()+"/admin/nhan-vien");
			return;
		}
		MyUtils.forward(getServletContext(), request, response, "/admin/nhan-vien-cap-nhat.jsp");
	}

}
