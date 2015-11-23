<%@page import="com.bansach.model.bean.LoaiSanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Thêm thông tin sản phẩm</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
        
        <!--body  -->
	
	
		<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doSanPhamThem" method="post" enctype="multipart/form-data">
			
			<c:if test="${arrLoaiSanPham.size()!=0}">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<input type="hidden" name="anhSanPham" value=""> 
						<img src="<%=request.getContextPath()%>/resources/images/noimage.png" class="avatar img-circle" alt="San pham" width="200" height="200">
						<h6>Chọn ảnh khác...</h6>
		
						<input type="file" name="anhSanPham" value="" class="form-control">
					</div>
				</div>
		
				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Loại sản phẩm</label>
						<div class="col-lg-8">
						<%
							ArrayList<LoaiSanPham> arrLoaiSanPham = (ArrayList<LoaiSanPham>) request.getAttribute("arrLoaiSanPham");
						%>
							<select class="form-control input-medium" name="tenLoaiSP">
							<% for (LoaiSanPham loaiSanPham : arrLoaiSanPham) { %>
							
								<option value="<%=loaiSanPham.getTen()%>"><%=loaiSanPham.getTen()%></option>
								
							<% } %>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Tên</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="tenSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Giá</label>
						<div class="col-lg-8">
							<input class="form-control" type="number" name="giaSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Tác giả</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="tacGia" class="input-medium" />
						</div>
					</div>
					
					<!--      -->
					<div class="form-group">
						<label class="col-lg-3 control-label">Nhà xuất bản</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="nhaXuatBanSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Trọng lượng</label>
						<div class="col-lg-8">
							<input class="form-control" type="number" name="trongLuongSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Kích thước</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="kichThuocSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Số trang</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="soTrangSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Mô tả</label>
						<div class="col-lg-8">
							<textarea class="form-control input-medium" name="moTaSP" rows="10"></TEXTAREA>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label"></label>
						<div class="col-md-8">
						  <input type="submit" class="btn btn-primary" value="Thêm">
						  <span></span>
						  <a href="<%=request.getContextPath() %>/admin/san-pham" class="btn btn-default">Hủy</a>
						</div>
				  </div>
			  </div>
			  </c:if>
			
			
			<c:if test="${arrLoaiSanPham.size()==0}">
				<div class="alert alert-danger" role="alert">
					<button type="button" class="close" data-dismiss="alert">x</button>
					  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
					  <span class="sr-only">Error:</span>
					  Không có loại sản phẩm nào để thêm sản phẩm mới
				</div>
			</c:if>
		</form>
	
	
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>