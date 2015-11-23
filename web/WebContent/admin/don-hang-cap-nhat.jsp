<%@page import="com.bansach.model.bo.SanPhamBO"%>
<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.bansach.model.bean.ChiTietDonHang"%>
<%@page import="com.bansach.utils.DateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bansach.model.bean.DonHang"%>
<%@page import="com.bansach.model.bean.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Thông tin đơn hàng</h1>
			</div>
			<!-- /.col-lg-12  -->
			</div>

		<!--body  -->
		<c:if test="${donHang!=null && arrKhachHang.size()!=0 }">
			<%
				DonHang donHang = (DonHang) request.getAttribute("donHang");
				KhachHang khachHang = (KhachHang) request.getAttribute("KhachHang");
				if (khachHang == null) {
					khachHang = new KhachHang();
				}
			%>
			<div class="col-md-6">
				<form class="form-horizontal" role="form" action="<%=request.getContextPath() %>/doDonHangCapNhat" method="post">
			
					<input type="hidden" name="maDonHang" value="<%=donHang.getMaDonHang()%>"> 
					<input type="hidden" name=maKhachHang value="<%=donHang.getMaKhachHang()%>">
					
					<div class="form-group">
						<label class="col-md-3 control-label">Khách hàng</label>
						<div class="col-md-6">
							<input disabled="disabled" value="<%=khachHang.getTen() %>" class="form-control" type="text" name="" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Điện thoại</label>
						<div class="col-md-6">
							<input disabled="disabled" value="<%=khachHang.getSoDienThoai() %>" class="form-control" type="text" name="" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Mail</label>
						<div class="col-md-6">
							<input disabled="disabled" value="<%=khachHang.getEmail() %>" class="form-control" type="text" name="" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Địa chỉ</label>
						<div class="col-md-6">
							<input value="<%=khachHang.getDiaChi() %>" class="form-control" type="text" name="" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Ngày đặt</label>
						<div class="col-md-6">
							<input disabled="disabled" value="<%=DateUtils.formatDatetime(donHang.getNgayDat())%>" class="form-control" type="text" name="ngayDatHang" class="input-medium" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Ghi chú</label>
						<div class="col-md-6">
							<TEXTAREA class="form-control input-medium" name="ghiChu" rows="5"><%=donHang.getGhiChu()%></TEXTAREA>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label">Trạng thái</label>
						<div class="col-md-6">
							<select class="form-control input-medium" name="trangThai">
								<OPTION value="DaXem" <%if("ChuaXem".equals(donHang.getTrangThai())||"DaXem".equals(donHang.getTrangThai())){%>selected<% } %>>Đã Xem</OPTION>
					          	<OPTION value="DangXuLy" <%if("DangXuLy".equals(donHang.getTrangThai())){%>selected<% } %>>Đang Xử Lý</OPTION>
					          	<OPTION value="DaXuLy" <%if("DaXuLy".equals(donHang.getTrangThai())){%>selected<% } %>>Đã Xử Lý</OPTION>
					          	<OPTION value="HuyBo" <%if("HuyBo".equals(donHang.getTrangThai())){%>selected<% } %>>Hủy Bỏ</OPTION>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-6">
						  <input type="submit" class="btn btn-primary" value="Cập nhật">
						  <span></span>
						  <a href="<%=request.getContextPath() %>/admin/don-hang" class="btn btn-default">Hủy</a>
						</div>
				  	</div>
				</form>
			</div>
			
			<!-- Chi tiet don hang -->
			<div class="col-md-6">
				<table class="table table-border">
					<thead>
						<tr>
							<td>Mã Sản phẩm</td>
							<td>Số lượng</td>
							<td>Đơn giá</td>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<ChiTietDonHang> listCTDH = (ArrayList<ChiTietDonHang>) request.getAttribute("ListChiTietDonHang");
							BigDecimal tongTien = new BigDecimal(0);
							SanPhamBO spBO = new SanPhamBO();
							if (listCTDH == null || listCTDH.size() == 0) {
								%>
									<tr><td colspan="3">Không có chi tiết</td></tr>
								<%
							} else {
								
								for (ChiTietDonHang c : listCTDH) {
									tongTien = tongTien.add(c.getGia().multiply(new BigDecimal(c.getSoLuong()))); 
								%>
									<tr>
										<td><%=c.getMaSanPham() %></td>
										<td><%=c.getSoLuong() %></td>
										<td><%=c.getGia() %></td>
									</tr>
								<%
								}
							}
						%>
						<tr>
							<td style="font-weight: bold; text-align: right;" colspan="2">Tổng tiền</td>
							<td><%=tongTien  %></td>
						</tr>
					</tbody>
					
					
					
				</table>
			</div>
		</c:if>
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>