<%@page import="com.bansach.model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<!--content  -->
	<tiles:putAttribute name="content">
	
		<!-- DataTables CSS -->
		<link href="<%=request.getContextPath()%>/resources/datatable-bootstrap/css/dataTables.bootstrap.css" rel="stylesheet" />
	
		<!-- DataTables Responsive CSS -->
		<link href="<%=request.getContextPath()%>/resources/datatable-responsive/css/dataTables.responsive.css" rel="stylesheet" />
			
		<div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Danh sách khách hàng</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
        
        <!--body  -->
        <p>
			<a class="btn btn-success" href="<%=request.getContextPath() %>/admin/khach-hang/them" >Thêm <i class="fa fa-plus"></i></a><span></span>
		</p>
		
		<table class="table table-striped table-bordered table-hover" id="dataTables-dsKhachHang">
		<thead>
			<tr>
				<th>Mã</th>
				<th>Tên</th>
				<th>Email</th>
				<th>Điện thoại</th>
				<th>Ngày sinh</th>
				<!-- <th>Địa chỉ</th> -->
				<!-- <th>Ghi chú</th> -->
				<th></th>
			</tr>
    	</thead>
    	<tbody id="tbl-body">
		    <c:if test="${arrKhachHang.size()!=0}">
				<%
					ArrayList<KhachHang> arrKhachHang= (ArrayList<KhachHang>)request.getAttribute("arrKhachHang");
					for(KhachHang khachHang : arrKhachHang){
				%>
		    	<tr>
					<td><%=khachHang.getMaKhachHang()%></td>
					<td><%=khachHang.getTen()%></td>
					<td><%=khachHang.getEmail()%></td>
					<td><%=khachHang.getSoDienThoai()%></td>
					<td><%=khachHang.getNgaySinh()%></td>
					<%-- <td><%=khachHang.getDiaChi()%></td> --%>
					<%-- <td><%=khachHang.getGhiChu()%></td> --%>
					<td>
						<input type="hidden" id="hidden-maKhachHang" value="<%=khachHang.getMaKhachHang()%>" />
							<a class="btn btn-default" href="<%=request.getContextPath() %>/admin/khach-hang/cap-nhat?maKhachHang=<%=khachHang.getMaKhachHang()%>"><i class="fa fa-edit"></i></a>
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
					action="<%=request.getContextPath()%>/doKhachHangXoa"
					method="post">
					<input id="modal-hidden-maKhachHang" type="hidden" value=""
						name="maKhachHang" />
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
				$('#dataTables-dsKhachHang').DataTable({
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
					var maKhachHang = $(this).siblings('input#hidden-maKhachHang').val();
					// set ma vao modal
					$('#modal-hidden-maKhachHang').val(maKhachHang);
				});
			});
		</script>
	
	</tiles:putAttribute>

</tiles:insertTemplate>