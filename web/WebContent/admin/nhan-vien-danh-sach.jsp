<%@page import="com.bansach.model.bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
	
		<!-- DataTables CSS -->
		<link href="<%=request.getContextPath()%>/resources/datatable-bootstrap/css/dataTables.bootstrap.css" rel="stylesheet" />

		<!-- DataTables Responsive CSS -->
		<link href="<%=request.getContextPath()%>/resources/datatable-responsive/css/dataTables.responsive.css" rel="stylesheet" />
	
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Danh sách nhân viên</h1>
			</div>
			<!-- /.col-lg-12  -->
		</div>

		<!--body  -->
		<p>
			<a class="btn btn-success" href="<%=request.getContextPath()%>/admin/nhan-vien/them" >Thêm <i class="fa fa-plus"></i></a><span></span>
		</p>
		
		<table class="table table-striped table-bordered table-hover" id="dataTables-dsNhanVien">
			<thead>
				<tr>
					<th>Mã nhân viên</th>
					<th>Tên</th>
					<th>Tên đăng nhập</th>
					<th>Mật khẩu</th>
					<th>Ghi chú</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody id="tbl-body">
				<c:if test="${arrNhanVien.size()!=0}">
					<%
						ArrayList<NhanVien> arrNhanVien = (ArrayList<NhanVien>) request.getAttribute("arrNhanVien");
						for (NhanVien nhanVien : arrNhanVien) {
					%>
					<tr>
						<td><%=nhanVien.getMaNhanVien()%></td>
						<td><%=nhanVien.getTen()%></td>
						<td><%=nhanVien.getTenDangNhap()%></td>
						<td><%=nhanVien.getMatKhau()%></td>
						<td><%=nhanVien.getGhiChu()%></td>
						<td>
							<input type="hidden" id="hidden-maNhanVien" value="<%=nhanVien.getMaNhanVien()%>" />
							<a class="btn btn-default" href="<%=request.getContextPath()%>/admin/nhan-vien/cap-nhat?maNhanVien=<%=nhanVien.getMaNhanVien()%>"><i class="fa fa-edit"></i></a>
							<button type="button" id="btn-xoa" class="btn btn-default" data-toggle="modal" data-target="#myModal" ><i class="fa fa-remove"></i></button>
						</td>
					</tr>
					<%
						}
					%>
				</c:if>
			</tbody>
		</table>
		
		<div id="myModal" class="modal fade" role="dialog">

			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<form id="form-xoa"
						action="<%=request.getContextPath()%>/doNhanVienXoa"
						method="post">
						<input id="modal-hidden-maNhanVien" type="hidden" value=""
							name="maNhanVien" />
						<div class="modal-header">
							<a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
							<h3>Xóa</h3>
						</div>
						<div class="modal-body">
							<p>Bạn có chắc chắn muốn xóa thông tin này?</p>
						</div>
						<div class="modal-footer">
							<button type="submit" id="btnYes" class="btn btn-danger">Có</button>
							<button type="button" data-dismiss="modal" aria-hidden="true"
								class="btn btn-secondary">Không</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		
	</tiles:putAttribute>

	<tiles:putAttribute name="javascript-source">
	
		<!-- DataTables JavaScript -->
		<script src="<%=request.getContextPath()%>/resources/datatable/js/jquery.dataTables.min.js"></script>

		<script src="<%=request.getContextPath()%>/resources/datatable-bootstrap/js/dataTables.bootstrap.min.js"></script>
		
		<script>
			$(document).ready( function() {
				$('#dataTables-dsNhanVien').DataTable({
						responsive : true,
						language : {
							"sProcessing" : "Đang xử lý...",
							"sLengthMenu" : "Xem _MENU_ mục",
							"sZeroRecords" : "Không tìm thấy dòng nào phù hợp",
							"sInfo" : "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
							"sInfoEmpty" : "Đang xem 0 đến 0 trong tổng số 0 mục",
							"sInfoFiltered" : "(được lọc từ _MAX_ mục)",
							"sInfoPostFix" : "",
							"sSearch" : "Tìm:",
							"sUrl" : "",
							"oPaginate" : {
								"sFirst" : "Đầu",
								"sPrevious" : "Trước",
								"sNext" : "Tiếp",
								"sLast" : "Cuối"
							}
						}
					});
				});
		</script>
		
		<!--lay ma de xoa -->
		<script type="text/javascript">
			$(document).ready(function() {
				// lay ma dot dang ky	
				$('#tbl-body').on('click', 'button#btn-xoa', function() {
					// lay ma dot dang ky
					var maNhanVien = $(this).siblings('input#hidden-maNhanVien').val();
					// set ma vao modal
					$('#modal-hidden-maNhanVien').val(maNhanVien);
				});
			});
		</script>
	
	</tiles:putAttribute>

</tiles:insertTemplate>