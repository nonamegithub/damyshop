package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.KhachHangBO;
import com.bansach.utils.MyUtils;

public class KhachHangCapNhatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KhachHangCapNhatServlet() {
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
		
		KhachHangBO khachHangBO = new KhachHangBO();
		String maKhachHang = (String) request.getParameter("maKhachHang");
		String errorParse = null;
		KhachHang khachHang = null;
		try{
			Integer maKH = Integer.parseInt(maKhachHang);
			khachHang = khachHangBO.getKhachHangTheoMa(maKH);
			request.setAttribute("khachHang", khachHang);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//co loi
		if(errorParse!=null||khachHang==null){
			response.sendRedirect(request.getContextPath()+"/admin/khach-hang");
			return;
		}
		
		// ko co loi
		MyUtils.forward(getServletContext(), request, response, "/admin/khach-hang-cap-nhat.jsp");
	}

}
