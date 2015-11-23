package com.bansach.utils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bansach.model.bean.ChiTietDonHang;
import com.bansach.model.bean.ChiTietGioHang;
import com.bansach.model.bean.GioHang;
import com.bansach.model.bean.NhanVien;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.SanPhamBO;

public class MyUtils {

	// them san pham vao gio hang
	public static void themVaoGioHang(HttpSession session, ChiTietDonHang ctdh) {
		// lay gio hang tu session
		GioHang gioHang = getGioHang(session);

		// kiem tra GioHang co ton tai trong session
		// neu chua co thi tao moi
		if (gioHang == null) {
			gioHang = new GioHang();
			setGioHang(session, gioHang);
		}

		// kiem tra trong gio hang neu da co san pham nay roi thi chi tang so
		// luong
		ArrayList<ChiTietDonHang> c = gioHang.getListSanPham();
		for (ChiTietDonHang ct : c) {
			if (ct.getMaSanPham() == ctdh.getMaSanPham()) {
				ct.setSoLuong(ct.getSoLuong() + ctdh.getSoLuong());
				return;
			}
		}

		// them san pham moi(new) vao GioHang
		gioHang.themHang(ctdh);
	}

	public static void xoaKhoiGioHang(HttpSession session, int maSanPham) {
		// lay gio hang tu session
		GioHang gioHang = getGioHang(session);

		// kiem tra GioHang co ton tai trong session
		// neu chua co thi tao moi
		if (gioHang == null) {
			gioHang = new GioHang();
			setGioHang(session, gioHang);
		}

		// xoa item khoi gio hang
		for (ChiTietDonHang c : gioHang.getListSanPham()) {
			if (c.getMaSanPham() == maSanPham) {
				// xoa hang
				gioHang.xoaHang(c);

				// cap nhat lai session
				setGioHang(session, gioHang);
				return;
			}
		}
	}

	// lay gio hang tu session
	public static GioHang getGioHang(HttpSession session) {
		GioHang gioHang = (GioHang) session.getAttribute("GioHang");
		return gioHang;
	}

	// luu GioHang vao session
	private static void setGioHang(HttpSession session, GioHang gioHang) {
		session.setAttribute("GioHang", gioHang);
	}

	// cap nhat so luong san pham trong gio hang
	public static void setSoLuong(GioHang gioHang, int maSanPham, int soLuong) {
		for (ChiTietDonHang c : gioHang.getListSanPham()) {
			if (c.getMaSanPham() == maSanPham) {
				c.setSoLuong(soLuong);
				return;
			}
		}
	}

	/**
	 * <h1>forward</h1> Chuyen trang
	 * 
	 * @param servletContext
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 * @throws ServletException
	 * 
	 */
	public static void forward(ServletContext servletContext,
			HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException {
		RequestDispatcher rd = servletContext.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	public static String shortString(String str) {
		if (str == null)
			return "";
		if (str.length() < 60)
			return str;
		else {
			return str.substring(0, 55) + "...";
		}
	}

	public static String shortName(String name) {
		if (name == null)
			return "";
		if (name.length() < 50)
			return name;
		else {
			return name.substring(0, 45) + "...";
		}
	}

	public static ArrayList<ChiTietGioHang> getChiTietGioHang(
			HttpSession session) {
		// prepare BO, list, object
		SanPhamBO spBO = new SanPhamBO();
		ArrayList<ChiTietGioHang> ctghList = new ArrayList<ChiTietGioHang>();
		ChiTietGioHang ctGioHang = null;
		SanPham sp = null;
		BigDecimal total = BigDecimal.ZERO;

		// get GioHang from session
		GioHang gioHang = MyUtils.getGioHang(session);

		if (gioHang != null) {
			ArrayList<ChiTietDonHang> c = gioHang.getListSanPham();
			for (ChiTietDonHang ctdh : c) {
				sp = spBO.getSanPhamTheoMa(ctdh.getMaSanPham());
				ctGioHang = new ChiTietGioHang(sp.getMaSanPham(), sp.getAnh(),
						sp.getTen(), ctdh.getSoLuong(), sp.getGia());
				ctghList.add(ctGioHang);

				// total
				total = total.add(sp.getGia().multiply(
						BigDecimal.valueOf(ctdh.getSoLuong())));
			}
		}

		return ctghList;
	}

	public static void invalidateSessiob(HttpSession session) {
		session.invalidate();
	}

	/**
	 * <h1>getImageURL</h1 Tra ve duong dan cua anh, neu anh khong ton tai thi
	 * tra ve anh mac dinh(noimage.png)
	 * 
	 * @param request
	 * @param fileName
	 * @return imageURL
	 */
	public static String getImageURL(HttpServletRequest request, String fileName) {
		String resultURL = request.getContextPath() + "/resources/images/noimage.png";
		
		// kiem tra anh co ton tai trong server hay khong
		// neu co thi tra ve duong dan
		if (fileName != null && fileName.trim().length() > 0) {
			String realPath = request.getServletContext().getRealPath("") + "resources\\images" + java.io.File.separator + fileName ;
			File file = new File(realPath);
			if (file.exists()) {
				resultURL = request.getContextPath() + "/resources/images/" + fileName;
			}
		}
		return resultURL;
	}
	
	
	public static void storeLoginedNhanVienToSession(HttpSession session, NhanVien nv) {
		session.setAttribute("LoginedNhanVien", nv);
	}
	
	public static NhanVien getNhanVienFromSession(HttpSession session) {
		NhanVien nv = (NhanVien) session.getAttribute("LoginedNhanVien");
		return nv;
	}
	
}
