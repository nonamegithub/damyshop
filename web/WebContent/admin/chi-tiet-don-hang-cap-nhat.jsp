<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bansach.model.bean.ChiTietDonHang"%>
<%@page import="com.bansach.utils.DateUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>CapNhatChiTietDonHang</title>
</head>
<body>
	<h3 style="color: red;">Cập nhật đơn hàng</h3>
	<c:if test="${chiTietDonHang!=null && arrSanPham.size()!=0 }">
	<%	
		String tenSanPham = null;
		ChiTietDonHang chiTietDonHang = (ChiTietDonHang) request.getAttribute("chiTietDonHang");
		ArrayList<SanPham> arrSanPham = (ArrayList<SanPham>) request.getAttribute("arrSanPham");
		for(SanPham sanPham : arrSanPham){
			if(chiTietDonHang.getMaSanPham()==sanPham.getMaSanPham())
				tenSanPham = sanPham.getTen();
		}
	%>
	<form action="<%=request.getContextPath()%>/doChiTietDonHangCapNhat" method="post">
		Mã đơn hàng:
		<%=chiTietDonHang.getMaDonHang()%><input type="hidden" name="maDonHang" value="<%=chiTietDonHang.getMaDonHang()%>"> <br/>
		Tên sản phẩm :
		<input type="hidden" name=maSanPham value="<%=chiTietDonHang.getMaSanPham()%>">
		<%=tenSanPham %><br/> 
		Giá:
		<input type="text" name="gia" value="<%=chiTietDonHang.getGia()%>"> <br/>
		Số lượng:
		<input type="text" name="soLuong" value="<%=chiTietDonHang.getSoLuong()%>"> <br/>
		
		<input type="submit" value="Cập Nhật"> <a href="<%=request.getContextPath()%>/admin/chi-tiet-don-hang">Hủy</a>
	</form>
	</c:if>
</body>
</html>