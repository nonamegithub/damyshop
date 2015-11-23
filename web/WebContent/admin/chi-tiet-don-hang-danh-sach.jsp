<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="com.bansach.model.bean.ChiTietDonHang"%>
<%@page import="com.bansach.utils.DateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>DSChiTietDonHang</title>
</head>
<body>
	<a href="<%=request.getContextPath() %>/admin/chi-tiet-don-hang/them">Thêm chi tiết đơn hàng	</a><br/>
	<table border="1">
    <tr>
    <th>Mã đơn hàng</th>
	<th>Tên sản phẩm</th>
	<th>Giá</th>
	<th>Số lượng</th>
	<th>Action</th>
    </tr>
     <c:if test="${arrChiTietDonHang.size()!=0 && arrSanPham.size()!=0}">
	<%
		ArrayList<ChiTietDonHang> arrChiTietDonHang= (ArrayList<ChiTietDonHang>)request.getAttribute("arrChiTietDonHang");
		for(ChiTietDonHang chiTietDonHang: arrChiTietDonHang){
		String tenSanPham = null;
		ArrayList<SanPham> arrSanPham= (ArrayList<SanPham>)request.getAttribute("arrSanPham");
		for(SanPham sanPham: arrSanPham){
			if(sanPham.getMaSanPham()==chiTietDonHang.getMaSanPham())
				tenSanPham = sanPham.getTen();
		}
	%>
	<tr>
		<td><%=chiTietDonHang.getMaDonHang()%></td>
		<td><%=tenSanPham%></td>
		<td><%=chiTietDonHang.getGia()%></td>
		<td><%=chiTietDonHang.getSoLuong()%></td>
		<td>
			<a href="<%=request.getContextPath() %>/admin/chi-tiet-don-hang/cap-nhat?maDonHang=<%=chiTietDonHang.getMaDonHang()%>&maSanPham=<%=chiTietDonHang.getMaSanPham() %>">Sửa</a>
			<a href="<%=request.getContextPath() %>/doChiTietDonHangXoa?maDonHang=<%=chiTietDonHang.getMaDonHang()%>&maSanPham=<%=chiTietDonHang.getMaSanPham() %>" onclick="return confirm('Ban co chac chan muon xoa?')">Xóa</a>
		</td>
	<% }%>
	</c:if>
	</tr>
	</table>
</body>
</html>