<%@page import="com.bansach.model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cập nhật thông tin nhân viên</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>

		<!--body  -->
		<c:if test="${nhanVien!=null}">
		<%
			NhanVien nhanVien = (NhanVien) request.getAttribute("nhanVien");
		%>
		<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/doNhanVienCapNhat" method="post">
			<input type="hidden" name="maNhanVien" value="<%=nhanVien.getMaNhanVien() %>"/>
			<div class="form-group">
				<label class="col-lg-2 control-label">Tên nhân viên</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="<%=nhanVien.getTen() %>" name="ten" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Tên đăng nhập</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="<%=nhanVien.getTenDangNhap() %>" name="tenDangNhap" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Mật khẩu</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" value="<%=nhanVien.getMatKhau() %>" name="matKhau" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Ghi chú</label>
				<div class="col-lg-8">
					<TEXTAREA class="form-control input-medium" value="<%=nhanVien.getGhiChu() %>" name="ghiChu" rows="5"></TEXTAREA>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label"></label>
				<div class="col-md-8">
				  <input type="submit" class="btn btn-primary" value="Tạo">
				  <span></span>
				  <a href="<%=request.getContextPath()%>/admin/nhan-vien" class="btn btn-default">Hủy</a>
				</div>
		  	</div>
		</form>
		</c:if>
</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>