<%@page import="com.bansach.model.bean.LoaiSanPham"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Cập nhật thông tin loại sản phẩm</h1>
			</div>
			<!-- /.col-lg-12  -->
			</div>

		<!--body  -->
		<c:if test="${loaiSanPham!=null}">
			<%
				LoaiSanPham loaiSanPham = (LoaiSanPham) request.getAttribute("loaiSanPham");
			%>
		<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doLoaiSanPhamCapNhat" method="post">
			
			<input type="hidden" name="maLoaiSP" value="<%=loaiSanPham.getMaLoai()%>">
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Tên loại sản phẩm</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="tenLSP" value="<%=loaiSanPham.getTen()%>" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Mô tả</label>
				<div class="col-lg-8">
					<TEXTAREA class="form-control input-medium" name="moTaLSP" rows="5"><%=loaiSanPham.getMoTa()%></TEXTAREA>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label"></label>
				<div class="col-md-8">
				  <input type="submit" class="btn btn-primary" value="Cập nhật">
				  <span></span>
				  <a href="<%=request.getContextPath() %>/admin/loai-san-pham" class="btn btn-default">Hủy</a>
				</div>
		  	</div>
		</form>
	</c:if>
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>