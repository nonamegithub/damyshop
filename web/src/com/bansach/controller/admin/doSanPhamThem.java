package com.bansach.controller.admin;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.bansach.model.bean.LoaiSanPham;
import com.bansach.model.bean.SanPham;
import com.bansach.model.bo.LoaiSanPhamBO;
import com.bansach.model.bo.SanPhamBO;

/**
 * Servlet implementation class doThemSanPham
 */
@WebServlet("/doSanPhamThem")
public class doSanPhamThem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public doSanPhamThem() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=utf-8");
		response.setCharacterEncoding("UTF-8");

		SanPhamBO sanPhamBO = new SanPhamBO();
		SanPham sanPham = null;
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();

		String tenLoaiSP = null;
		String tenSP = null;
		String giaSP = null;
		String tacGia = null;
		String nhaXuatBanSP = null;
		String trongLuongSP = null;
		String kichThuocSP = null;
		String soTrangSP = null;
		String moTaSP = null;
		String anhSanPham = null;
		Integer maLoai = null, trongLuong = 0, soTrang = 0;
		BigDecimal gia = new BigDecimal("0");

		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> formitems = upload.parseRequest(request);
			for (FileItem item : formitems) {

				// cÃ¡c parameter ten, tuoi,...
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
					switch (name) {
					case "tenLoaiSP":
						tenLoaiSP = value;
						break;
					case "tenSP":
						tenSP = value;
						break;
					case "giaSP":
						giaSP = value;
						break;
					case "tacGia":
						tacGia = value;
						break;
					case "nhaXuatBanSP":
						nhaXuatBanSP = value;
						break;
					case "trongLuongSP":
						trongLuongSP = value;
						break;
					case "kichThuocSP":
						kichThuocSP = value;
						break;
					case "soTrangSP":
						soTrangSP = value;
						break;
					case "moTaSP":
						moTaSP = value;
						break;
					case "anhSanPham":
						anhSanPham = value;
						break;
					}
				} else {
					// la file anh
					String fileName = item.getName();
					if (item.getSize() != 0) {
						// tao thu muc uploads
						String uploadDir = request.getServletContext().getRealPath("") + "resources"
								+ java.io.File.separator + "images";
						File dir = new File(uploadDir);
						// ten duoi file chon vao
						String duoiFile = FilenameUtils.getExtension(fileName);

						// la file anh
						if ("gif".equals(duoiFile) || "jpg".equals(duoiFile) || "png".equals(duoiFile)) {
							if (!dir.exists()) {
								dir.mkdirs();
							}
							anhSanPham = "Bnews-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
							// tao duong dan that den file tren dia
							String RealPathFile = uploadDir + File.separator + anhSanPham;
							// upload file len o dia
							File file = new File(RealPathFile);
							// out.println(RealPathFile);
							try {
								item.write(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						// khong phai file anh
						else {
							response.sendRedirect(request.getContextPath() + "/admin/san-pham/them");
							return;
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// Lay maLoai san pham tuong ung voi ten loai sp
		ArrayList<LoaiSanPham> arrLoaiSP = loaiSanPhamBO.getTatCaLoaiSanPham();
		for (LoaiSanPham loaiSanPham : arrLoaiSP) {
			if (tenLoaiSP.equals(loaiSanPham.getTen()))
				maLoai = loaiSanPham.getMaLoai();
		}

		try {
			if (giaSP == null)
				giaSP = "0";
			gia = new BigDecimal(giaSP);
			if (trongLuongSP == null)
				trongLuongSP = "0";
			trongLuong = Integer.parseInt(trongLuongSP);
			if (soTrangSP == null)
				soTrangSP = "0";
			soTrang = Integer.parseInt(soTrangSP);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		// them san pham thanh cong
		sanPham = new SanPham(maLoai, tenSP, gia, nhaXuatBanSP, trongLuong, kichThuocSP, soTrang, moTaSP, anhSanPham,
				tacGia);
		sanPhamBO.addSanPham(sanPham);
		response.sendRedirect(request.getContextPath() + "/admin/san-pham");
	}
}
