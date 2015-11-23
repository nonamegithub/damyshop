<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="com.bansach.model.bean.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ThemChiTietDonHang</title>
</head>
<body>
	<h3 style="color: red;">Thêm chi tiết đơn hàng</h3>
	<c:if test="${arrDonHang.size()!=0 && arrSanPham.size()!=0}">
	<%
		ArrayList<DonHang> arrDonHang = (ArrayList<DonHang>) request.getAttribute("arrDonHang");
		ArrayList<SanPham> arrSanPham = (ArrayList<SanPham>) request.getAttribute("arrSanPham");
	%>
		<form action="<%=request.getContextPath() %>/doChiTietDonHangThem" method="post">
		Mã đơn hàng:
		<select name="maDonHang">
		<%for(DonHang donHang : arrDonHang){ %>
		<option value="<%=donHang.getMaDonHang()%>"><%=donHang.getMaDonHang()%></option>
			<%} %>
		</select><br/>
		Tên sản phẩm:
		<select name="tenSanPham">
		<%for(SanPham sanPham : arrSanPham){ %>
		<option value="<%=sanPham.getTen()%>"><%=sanPham.getTen()%></option>
		<%}%>
		</select><br/>
		Số lượng: 
		<input type="text" name="soLuong"><br/>
		<input type="submit" value="Thêm"> <a href="<%=request.getContextPath() %>/admin/chi-tiet-don-hang">Hủy</a>
		</form>
	</c:if>
	<c:if test="${arrDonHang.size()==0||arrSanPham.size()==0}">
	<h3>Không có đơn hàng hoặc sản phẩm để tạo chi tiết đơn hàng</h3>
	</c:if>
</body>
</html>