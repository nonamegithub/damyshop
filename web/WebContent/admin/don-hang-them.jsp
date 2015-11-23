<%@page import="com.bansach.model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thêm thông tin khách hàng</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>

		<!--body  -->	
		<c:if test="${arrKhachHang.size()!=0}">
			<% 
				ArrayList<KhachHang> arrKhachHang = (ArrayList<KhachHang>) request.getAttribute("arrKhachHang");
			%>
			<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doDonHangThem" method="post">
		
				<div class="form-group">
					<label class="col-lg-2 control-label">Tên khách hàng</label>
					<div class="col-lg-8">
						<select class="form-control input-medium" name="tenKhachHang">
							<%
								for(KhachHang khachHang : arrKhachHang){ 
							%>
							<option value="<%=khachHang.getTen()%>"><%=khachHang.getTen()%></option>
							<%
								} 
							%>
						</select>
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-lg-2 control-label">Ghi chú</label>
					<div class="col-lg-8">
						<TEXTAREA class="form-control input-medium" name="ghiChu" rows="5"></TEXTAREA>
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-lg-2 control-label"></label>
					<div class="col-md-8">
					  <input type="submit" class="btn btn-primary" value="Tạo">
					  <span></span>
					  <a href="<%=request.getContextPath() %>/admin/don-hang" class="btn btn-default">Hủy</a>
					</div>
		  		</div>
		  		
			</form>
		</c:if>
		<c:if test="${arrKhachHang.size()==0}">
			<div class="alert alert-danger" role="alert">
				<button type="button" class="close" data-dismiss="alert">x</button>
	  			<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	  			<span class="sr-only">Error:</span>
	  				Không có khách hàng nào để tạo đơn hàng mới
			</div>
		</c:if>
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>