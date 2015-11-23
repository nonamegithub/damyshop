<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="com.bansach.model.bean.LoaiSanPham"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Cập nhật thông tin sản phẩm</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
        
        <!--body  -->
	 <c:if test="${sanPham!=null && arrLoaiSP.size()!=0}">
	<%
		SanPham sanPham = (SanPham)request.getAttribute("sanPham"); 
		ArrayList<LoaiSanPham> arrLoaiSP = (ArrayList<LoaiSanPham>) request.getAttribute("arrLoaiSP");
	%>
	<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doSanPhamCapNhat" method="post" enctype="multipart/form-data">
	<%-- Mã sản phẩm: 
		<%=sanPham.getMaSanPham()%><input type="hidden" name="maSP" value="<%=sanPham.getMaSanPham()%>"><br/>
	Tên sản phẩm :
		<input type="text" name="tenSP" value="<%=sanPham.getTen()%>"><br/>
	Tên loại sản phẩm: 
		<SELECT id="chon" name="tenLoaiSP">
		<% for(LoaiSanPham loaiSanPham : arrLoaiSP ){%>			
          	<OPTION value="<%=loaiSanPham.getTen() %>" <%if(loaiSanPham.getMaLoai()==sanPham.getMaLoai()){%>selected<% } %>>
          	<%=loaiSanPham.getTen() %>
          	</OPTION>
		<%} %>
        </SELECT><br/>
	Giá :
		<input type="text" name="giaSP" value="<%=sanPham.getGia()%>"><br/>
	Tác giả:
		<input type="text" name="tacGia" value="<%=sanPham.getTacGia()%>"><br/>
	Nhà xuất bản:
		<input type="text" name="nhaXuatBanSP" value="<%=sanPham.getNhaXuatBan()%>"><br/>
	Trọng lượng:
		<input type="text" name="trongLuongSP" value="<%=sanPham.getTrongLuong()%>"><br/>
	Kích thước: 
		<input type="text" name="kichThuocSP" value="<%=sanPham.getKichThuoc()%>"><br/>
	Số trang:
		<input type="text" name="soTrangSP" value="<%=sanPham.getSoTrang()%>"><br/>
	Mô tả:
		<TEXTAREA name="moTaSP" rows="5"><%=sanPham.getMoTa()%></TEXTAREA><br/>
	Ảnh Đại Diện:
		<img src="<%=request.getContextPath()%>/resources/images/<%=sanPham.getAnh()%>" width="100" height="100"/>
		<input type="hidden" name="anhSanPham" value="<%=sanPham.getAnh()%>">
		<input type="file"  name="anhSanPham"><br/>
	<input type="submit" value="Cập Nhật"> <a href="<%=request.getContextPath() %>/admin/san-pham">Hủy bỏ</a>
	
	 --%>
				<input type="hidden" name="maSP" value="<%=sanPham.getMaSanPham()%>">
				<!-- left column -->
				<div class="col-md-3">
					<div class="text-center">
						<input type="hidden" name="anhSanPham" value="<%=sanPham.getAnh() %>"> 
						<img src="<%=request.getContextPath()%>/resources/images/noimage.png" class="avatar img-circle" alt="San pham" width="200" height="200">
						<h6>Chọn ảnh khác...</h6>
		
						<input type="file" name="anhSanPham" value="<%=sanPham.getAnh() %>" class="form-control">
					</div>
				</div>
		
				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Tên</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" name="tenSP" value="<%=sanPham.getTen()%>" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Loại sản phẩm</label>
						<div class="col-lg-8">
							<select class="form-control input-medium" id="chon" name="tenLoaiSP">
							<% for (LoaiSanPham loaiSanPham : arrLoaiSP ) {	%>			
					          	<OPTION value="<%=loaiSanPham.getTen() %>" <%if(loaiSanPham.getMaLoai()==sanPham.getMaLoai()){%>selected<% } %>> <%=loaiSanPham.getTen() %> </OPTION>
							<%	} %>
					        </select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Giá</label>
						<div class="col-lg-8">
							<input class="form-control" type="number" value="<%=sanPham.getGia()%>" name="giaSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Tác giả</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" value="<%=sanPham.getTacGia()%>" name="tacGia" class="input-medium" />
						</div>
					</div>
					
					<!--      -->
					<div class="form-group">
						<label class="col-lg-3 control-label">Nhà xuất bản</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" value="<%=sanPham.getNhaXuatBan()%>" name="nhaXuatBanSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Trọng lượng</label>
						<div class="col-lg-8">
							<input class="form-control" type="number" value="<%=sanPham.getTrongLuong()%>" name="trongLuongSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Kích thước</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" value="<%=sanPham.getKichThuoc() %>" name="kichThuocSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Số trang</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" value="<%=sanPham.getSoTrang() %>" name="soTrangSP" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Mô tả</label>
						<div class="col-lg-8">
							<textarea class="form-control input-medium" name="moTaSP" rows="10"><%=sanPham.getMoTa() %></TEXTAREA>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label"></label>
						<div class="col-md-8">
						  <input type="submit" class="btn btn-primary" value="Cập nhật">
						  <span></span>
						  <a href="<%=request.getContextPath() %>/admin/san-pham" class="btn btn-default">Hủy</a>
						</div>
				  </div>
			  </div>
	
	
	
	</form>
	</c:if>
</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>