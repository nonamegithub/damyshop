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

@WebServlet("/doSanPhamCapNhat")
public class doSanPhamCapNhat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public doSanPhamCapNhat() {
        super();
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
		
		String maSP = null;
		String tenSP = null;
		String tenLoaiSP = null;
		String giaSP = null;
		String tacGia= null;
		String nhaXuatBanSP = null;
		String trongLuongSP = null;
		String kichThuocSP = null;
		String soTrangSP = null;
		String moTaSP = null;
		String anhSanPham = null;
		BigDecimal gia = null;
		Integer ma=null;
		Integer maLoai = null;
		Integer trongLuong=0;
		Integer soTrang=0;
		String errorParse = null;
		SanPham sanPham = null;
		
		SanPhamBO sanPhamBO = new SanPhamBO();
		LoaiSanPhamBO loaiSanPhamBO = new LoaiSanPhamBO();
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> formitems = upload.parseRequest(request);
			for(FileItem item: formitems){
				if(item.isFormField()){
					//cac du lieu nhap vao tru file anh
					String name = item.getFieldName();
					String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
					switch(name){
					case "maSP" : maSP = value; break;
					case "tenSP" : tenSP = value; break;
					case "tenLoaiSP" : tenLoaiSP = value; break;
					case "giaSP" : giaSP= value; break;
					case "tacGia": tacGia=value; break;
					case "nhaXuatBanSP" : nhaXuatBanSP = value; break;
					case "trongLuongSP" : trongLuongSP=value; break;
					case "kichThuocSP" : kichThuocSP = value; break;
					case "soTrangSP" : soTrangSP = value; break;
					case "moTaSP" : moTaSP= value; break;
					case "anhSanPham" : anhSanPham = value; break;
					}
				}
				else{
					//la file
					String fileName = item.getName();
						if(item.getSize()!=0){
							//tao thu muc uploads
							String uploadDir = request.getServletContext().getRealPath("")+"resources"+ java.io.File.separator+"images";
							File dir = new File(uploadDir);
							String duoiFile = FilenameUtils.getExtension(fileName);
							//kiem tra file anh
							if("gif".equals(duoiFile)||"jpg".equals(duoiFile)||"png".equals(duoiFile)){
								if(!dir.exists()){
									dir.mkdirs();
								}
								anhSanPham = "Bnews-"+System.nanoTime()+"."+FilenameUtils.getExtension(fileName);
								//tao duong dan that den file tren dia
								String RealPathFile = uploadDir + File.separator + anhSanPham;
					
								//upload file len o dia
								File file = new File(RealPathFile);

								try {
									item.write(file);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									}
								}
							else{
								//khong phai file anh
								response.sendRedirect(request.getContextPath()+ "/admin/san-pham");
								return;
								}
						}
					}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Lay ma loai san pham tu ten loai san pham
		ArrayList<LoaiSanPham> arrLoaiSP = loaiSanPhamBO.getTatCaLoaiSanPham();
		for(LoaiSanPham loaiSanPham : arrLoaiSP){
			if(tenLoaiSP.equals(loaiSanPham.getTen()))
				maLoai = loaiSanPham.getMaLoai();
		}
		
		//chuyen doi du lieu va luu san pham
		try{
			ma = Integer.parseInt(maSP);
			trongLuong = Integer.parseInt(trongLuongSP);
			soTrang = Integer.parseInt(soTrangSP);
			gia = BigDecimal.valueOf((double)Double.parseDouble(giaSP));
			sanPham = new SanPham(ma,maLoai, tenSP, gia, nhaXuatBanSP, trongLuong, kichThuocSP, soTrang, moTaSP, anhSanPham,tacGia);
		}catch(NumberFormatException e){
			e.printStackTrace();
			errorParse = e.getMessage();
		}
		
		//Cap nhat thanh cong
		if(errorParse==null){
			sanPhamBO.updateSanPham(sanPham);
			response.sendRedirect(request.getContextPath()+"/admin/san-pham");
		}
		//du lieu nhap vao ko dung
		else
			response.sendRedirect(request.getContextPath()+"/admin/san-pham/cap-nhat?maSanPham="+maLoai);
	}

}

