package com.bansach.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.NhanVien;
import com.bansach.model.bo.NhanVienBO;
import com.bansach.utils.MyUtils;

/**
 * Servlet implementation class doLogin
 */
@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
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
		NhanVienBO nvBO = new NhanVienBO();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		NhanVien nv = nvBO.getNhanVienTheoTenDangNhapVaMatKhau(username, password);
		
		if (nv == null) {
			response.sendRedirect(request.getContextPath() + "/login?msg=Sai_Ten_Dang_Nhap_Hoac_Mat_Khau");
		} else {
			// login
			MyUtils.storeLoginedNhanVienToSession(request.getSession(), nv);
			response.sendRedirect(request.getContextPath() + "/admin");
		}
		
		
	}

}
