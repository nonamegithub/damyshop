<%@page import="com.bansach.model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cập nhật thông tin khách hàng</h1>
			</div>
			<!-- /.col-lg-12  -->
			</div>

		<!--body  -->
		<c:if test="${khachHang!=null}">
		<%
			KhachHang khachHang = (KhachHang) request.getAttribute("khachHang");
		%>
		<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doKhachHangCapNhat" method="post">
		
			<input type="hidden" name="maKhachHang" value="<%=khachHang.getMaKhachHang()%>"> 
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Tên</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="ten" value="<%=khachHang.getTen()%>" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Email</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="email" value="<%=khachHang.getEmail()%>" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Số điện thoại</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="soDienThoai" value="<%=khachHang.getSoDienThoai()%>" class="input-medium" />
				</div>
			</div>
		
			<div class="form-group">
				<label class="col-lg-2 control-label">Ngày sinh</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="ngaySinh" value="<%=khachHang.getNgaySinh()%>" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Địa chỉ</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="diaChi" value="<%=khachHang.getDiaChi()%>" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Ghi chú</label>
				<div class="col-lg-8">
					<TEXTAREA class="form-control input-medium" name="ghiChu" rows="5"><%=khachHang.getGhiChu()%></TEXTAREA>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label"></label>
				<div class="col-md-8">
				  <input type="submit" class="btn btn-primary" value="Cập nhật">
				  <span></span>
				  <a href="<%=request.getContextPath() %>/admin/khach-hang" class="btn btn-default">Hủy</a>
				</div>
		  	</div>
		  	
	</form>
	</c:if>
	
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>