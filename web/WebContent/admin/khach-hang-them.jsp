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
		<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doKhachHangThem" method="post">
	
			<div class="form-group">
				<label class="col-lg-2 control-label">Tên</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="ten" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Email</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="email" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Số điện thoại</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="soDienThoai" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Ngày sinh</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="ngaySinh" class="input-medium" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-2 control-label">Địa chỉ</label>
				<div class="col-lg-8">
					<input class="form-control" type="text" name="diaChi" class="input-medium" />
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
				  <a href="<%=request.getContextPath() %>/admin/khach-hang" class="btn btn-default">Hủy</a>
				</div>
		  	</div>
	
	</form>
	
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>