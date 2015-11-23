<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<meta content="charset=utf-8">

<title>Admin - Damy Shop</title>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=request.getContextPath()%>/resources/metismenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/resources/sb-admin-2/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getContextPath()%>/resources/fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

</head>
<body>
	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="">Admin</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User
							Profile</a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><a href="<%=request.getContextPath() %>/doLogout"><i class="fa fa-sign-out fa-fw"></i>
							Logout</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="<%=request.getContextPath() %>/admin"><i class="fa fa-dashboard fa-fw"></i>
							Home</a></li>
					<li><a href="<%=request.getContextPath() %>/admin/san-pham"><i class="fa fa-bar-chart-o fa-fw"></i>
							Sản phẩm<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath() %>/admin/san-pham">Danh sách sản phẩm</a></li>
							<li><a href="<%=request.getContextPath() %>/admin/san-pham/them">Thêm sản phẩm</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					<li><a href="<%=request.getContextPath() %>/admin/loai-san-pham"><i class="fa fa-bar-chart-o fa-fw"></i>
							Thể loại<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath() %>/admin/loai-san-pham">Danh sách thể loại</a></li>
							<li><a href="<%=request.getContextPath() %>/admin/loai-san-pham/them">Thêm thể loại</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					<li><a href="<%=request.getContextPath() %>/admin/don-hang"><i class="fa fa-bar-chart-o fa-fw"></i>
							Đơn hàng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath() %>/admin/don-hang">Danh sách đơn hàng</a></li>
							<li><a href="<%=request.getContextPath() %>/admin/don-hang/them">Tạo đơn hàng</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					<li><a href="<%=request.getContextPath() %>/admin/khach-hang"><i class="fa fa-bar-chart-o fa-fw"></i>
							Khách hàng<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath() %>/admin/khach-hang">Danh sách khách hàng</a></li>
							<li><a href="<%=request.getContextPath() %>/admin/khach-hang/them">Tạo khách hàng</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					<li><a href="<%=request.getContextPath() %>/admin/nhan-vien"><i class="fa fa-odnoklassniki fa-fw"></i>
							Nhân viên<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="<%=request.getContextPath() %>/admin/nhan-vien">Danh sách nhân viên</a></li>
							<li><a href="<%=request.getContextPath() %>/admin/nhan-vien/them">Thêm nhân viên</a></li>
						</ul> <!-- /.nav-second-level -->
					</li>
					
					
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<tiles:insertAttribute name="content"></tiles:insertAttribute>

				<!--  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                    </div>
                    <!-- /.col-lg-12 
                </div>  -->
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->
	
	<!-- jQuery -->
	<script src="<%=request.getContextPath()%>/resources/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	
	<!-- jQuery Validation  -->
	<script src="<%=request.getContextPath()%>/resources/jquery-validation/jquery.validate.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/metismenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath()%>/resources/sb-admin-2/js/sb-admin-2.js"></script>
	
	<!--javascript-source attribute  -->
	<tiles:insertAttribute name="javascript-source"></tiles:insertAttribute>
</body>
</html>