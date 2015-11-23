<%@page import="com.bansach.model.bean.KhachHang"%>
<%@page import="com.bansach.utils.DateUtils"%>
<%@page import="com.bansach.model.bean.DonHang"%>
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
                <h1 class="page-header">Danh sách đơn hàng</h1>
            </div>
            <!-- /.col-lg-12  -->
        </div>
        
        <!--body  -->
        <p>
			<a class="btn btn-success" href="<%=request.getContextPath() %>/admin/don-hang/them" >Thêm <i class="fa fa-plus"></i></a><span></span>
		</p>
		
		<table class="table table-striped table-bordered table-hover" id="dataTables-dsDonHang">
		<thead>
		    <tr>
		    	<th>Mã đơn hàng</th>
				<th>Tên khách hàng</th>
				<th>Ngày đặt</th>
				<th>Ghi chú</th>
				<th>Trạng thái</th>
				<th>Action</th>
		    </tr>
    	</thead>
    	<tbody id="tbl-body">
	    	<c:if test="${arrayDonHang.size()!=0 && arrayKhachHang.size()!=0}">
				<%
					ArrayList<DonHang> arrayDonHang= (ArrayList<DonHang>)request.getAttribute("arrayDonHang");
					for(int i =0;i<arrayDonHang.size();i++){
			
					String tenKhachHang = null;
					ArrayList<KhachHang> arrayKhachHang = (ArrayList<KhachHang>) request.getAttribute("arrayKhachHang");
					for(KhachHang khachHang : arrayKhachHang){
						if(arrayDonHang.get(i).getMaKhachHang()==khachHang.getMaKhachHang())
						tenKhachHang = khachHang.getTen();
						}
				%>
			    <tr>
					<td><%=arrayDonHang.get(i).getMaDonHang()%></td>
					<td><%=tenKhachHang %></td>
					<td><%=DateUtils.formatDatetime(arrayDonHang.get(i).getNgayDat()) %></td>
					<td><%=arrayDonHang.get(i).getGhiChu()%></td>
					<td><%=arrayDonHang.get(i).getTrangThai()%></td>
					<td>
						<input type="hidden" id="hidden-maDonHang" value="<%=arrayDonHang.get(i).getMaDonHang()%>" />
								<a class="btn btn-default" href="<%=request.getContextPath() %>/admin/don-hang/cap-nhat?maDonHang=<%=arrayDonHang.get(i).getMaDonHang()%>"><i class="fa fa-edit"></i></a>
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
					action="<%=request.getContextPath()%>/doDonHangXoa"
					method="post">
					<input id="modal-hidden-maDonHang" type="hidden" value=""
						name="maDonHang" />
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
				$('#dataTables-dsDonHang').DataTable({
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
					var maDonHang = $(this).siblings('input#hidden-maDonHang').val();
					// set ma vao modal
					$('#modal-hidden-maDonHang').val(maDonHang);
				});
			});
		</script>
	
	</tiles:putAttribute>

</tiles:insertTemplate>