package com.bansach.controller.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.DonHang;
import com.bansach.model.bean.GioHang;
import com.bansach.model.bean.KhachHang;
import com.bansach.model.bo.ChiTietDonHangBO;
import com.bansach.model.bo.DonHangBO;
import com.bansach.model.bo.KhachHangBO;
import com.bansach.utils.DateUtils;
import com.bansach.utils.MyUtils;

/**
 * Servlet implementation class doCheckout
 */
@WebServlet("/doCheckout")
public class doCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prepare BO, list, object
		KhachHangBO khBO = new KhachHangBO();
		DonHangBO donHangBO = new DonHangBO();
		ChiTietDonHangBO ctdhBO = new ChiTietDonHangBO();
		ArrayList<ChiTietDonHang> listCTDH = null;
		GioHang gioHang = null;
		KhachHang khachHang = null;
		DonHang donHang = null;
		int maKhachHang = 0;
		int maDonHang = 0;
		
		// request parameters
		String ten = request.getParameter("ten");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String ghiChu = request.getParameter("ghiChu");
		
		// get GioHang from session
		gioHang = MyUtils.getGioHang(request.getSession());
		
		if (gioHang == null || gioHang.getListSanPham().size() == 0) {
			// Gio hang trong
			// redirect
			response.sendRedirect(request.getContextPath() + "/checkout?err=Chua_chon_hang");
			
		} else {
			
			// tao khach hang
			khachHang = new KhachHang(ten, email, soDienThoai, ngaySinh, diaChi, ghiChu);
			maKhachHang = khBO.addKhachHang(khachHang);
			if (maKhachHang < 1) {
				// loi du lieu
				// redirect
				response.sendRedirect(request.getContextPath() + "/checkout?err=Loi_du_lieu");
			} else {
				// tao don hang
				donHang = new DonHang(maKhachHang, DateUtils.convertToTimestamp(new Date()), ghiChu, "ChuaXem");
				maDonHang = donHangBO.addDonHang(donHang);
				if (maDonHang < 1) {
					// loi du lieu
					// redirect
					response.sendRedirect(request.getContextPath() + "/checkout?err=Loi_du_lieu");
				} else {
					// them chi tien don hang
					// lay chi tiet don hang
					listCTDH = gioHang.getListSanPham();
					for (ChiTietDonHang c : listCTDH) {
						c.setMaDonHang(maDonHang);
						ctdhBO.addChiTietDonHang(c);
					}
					// dat hang thanh cong
					// redirect
					response.sendRedirect(request.getContextPath() + "/checkout?msg=Mua_hang_thanh_cong");
				}
			}
			
			// invalidate session
			MyUtils.invalidateSessiob(request.getSession());
		}
		
	}

}
