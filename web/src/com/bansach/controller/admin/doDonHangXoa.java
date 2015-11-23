package com.bansach.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bo.DonHangBO;

/**
 * Servlet implementation class doDonHangXoa
 */
@WebServlet("/doDonHangXoa")
public class doDonHangXoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doDonHangXoa() {
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
		
		String maDonHang = request.getParameter("maDonHang");
		
		DonHangBO donHangBO = new DonHangBO();
		try{
			int maDH = Integer.parseInt(maDonHang);
			donHangBO.deleteDonHang(maDH);
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/admin/don-hang");
	}

}
