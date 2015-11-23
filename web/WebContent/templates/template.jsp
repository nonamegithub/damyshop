<%@page import="java.math.BigDecimal"%>
<%@page import="com.bansach.model.bean.ChiTietGioHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bansach.utils.MyUtils"%>
<%@page import="com.bansach.model.bean.GioHang"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Damy Shop</title>

<!-- CSS -->
<link href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/jquery.bxslider.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet">


</head>
<body>
<header>
	    <div class="container">
	        <div class="row">

	        	<!-- Logo -->
	            <div class="col-lg-4 col-md-3 hidden-sm hidden-xs">
	            	<div class="well logo">
	            		<a href="<%=request.getContextPath() %>/home">
	            			Damy <span>Shop</span>
	            		</a>
	            		<div>Nothing is free.</div>
	            	</div>
	            </div>
	            <!-- End Logo -->

				<!-- Search Form -->
	            <div class="col-lg-5 col-md-5 col-sm-7 col-xs-12">
	            	<div class="well">
	                    <form id="form-search" action="<%=request.getContextPath() %>/search" method="post">
	                        <div class="input-group panel panel-default">
								<input name="q" value="<%=request.getAttribute("query") == null ? "" : request.getAttribute("query") %>" type="text" class="form-control" placeholder="Tìm kiếm...">
								<input name="opt" id="hidden-option" type="hidden" value="default" />
								<div class="input-group-btn">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										Tìm <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" >
										<li><input value="t" class="a-hidden-opt" type="hidden"/><a class="btn-option" href="#">Tên sách</a></li>
										<li><input value="tg" class="a-hidden-opt" type="hidden"/><a class="btn-option" href="#">Tác giả</a></li>
										<li><input value="mt" class="a-hidden-opt" type="hidden"/><a class="btn-option" href="#">Mô tả</a></li>
										<li role="separator" class="divider"></li>
										<li><a href="#">Something else</a></li>
									</ul>
								</div>
								<!-- /btn-group -->
								<!-- <span class="input-group-btn">
									<button class="btn btn-default" type="button">Go!</button>
								</span> -->
							</div>
	                    </form>
	                </div>
	            </div>
	            <!-- End Search Form -->

	            <!-- Shopping Cart List -->
	            <%
		            BigDecimal total = BigDecimal.ZERO;
		            ArrayList<ChiTietGioHang> ctghList = MyUtils.getChiTietGioHang(session);
		            boolean flagNull = (ctghList == null || ctghList.size() == 0);
	            %>
	            <div class="col-lg-3 col-md-4 col-sm-5">
	                <div class="well">
	                    <div class="btn-group btn-group-cart">
	                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
	                            <span class="pull-left"><i class="fa fa-shopping-cart icon-cart"></i></span>
	                            <span class="pull-left">Shopping Cart: <%=flagNull ? 0 : ctghList.size() %> item(s)</span>
	                            <span class="pull-right"><i class="fa fa-caret-down"></i></span>
	                        </button>
	                        <ul class="dropdown-menu cart-content" role="menu">
	                        <%
				            	if (flagNull) {
				            		%>
				            			<li>
		                                    <a href="#">
		                                        <b>Không có sản phẩm nào</b>
		                                    </a>
		                                </li>
				            		<%
				            	} else {
				            		for (ChiTietGioHang ct : ctghList) {
				            			total = total.add(ct.getGia().multiply(BigDecimal.valueOf(ct.getSoLuong())));
				            			%>
				            			<li>
		                                    <a href="<%=request.getContextPath() %>/detail?productCode=<%=ct.getMaSanPham()%>">
		                                        <b><%=ct.getTenSanPham() %></b>
		                                        <span>x<%=ct.getSoLuong() %> <%=ct.getGia() %> VNĐ</span>
		                                    </a>
		                                </li>
				            			<%
				            		}
				            	}
				            %>
                                <li class="divider"></li>
                                <li><a href="<%=request.getContextPath() %>/cart">Total: <%=total %> VNĐ</a></li>
                            </ul>
	                    </div>
	                </div>
	            </div>
	            <!-- End Shopping Cart List -->
	        </div>
	    </div>
    </header>
    
    <!-- Body -->
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
    
    <footer>
    	<div class="container">
        	<div class="col-lg-3 col-md-3 col-sm-6">
        		<div class="column">
        			<h4>Information</h4>
        			<ul>
        				<li><a href="#">About Us</a></li>
        				<li><a href="#">Policy Privacy</a></li>
        				<li><a href="#">Terms and Conditions</a></li>
        				<li><a href="#">Shipping Methods</a></li>
        			</ul>
        		</div>
        	</div>
        	<div class="col-lg-3 col-md-3 col-sm-6">
        		<div class="column">
        			<h4>Categories</h4>
        			<ul>
        				<li><a href="#">Noname</a></li>
        				<li><a href="#">Damy</a></li>
        				<li><a href="#">Funny</a></li>
        				<li><a href="#">Fiction</a></li>
        			</ul>
        		</div>
        	</div>
        	<div class="col-lg-3 col-md-3 col-sm-6">
        		<div class="column">
        			<h4>Customer Service</h4>
        			<ul>
        				<li><a href="#">Contact Us</a></li>
        				<li><a href="#">Mail: contact.damy@damy.com</a></li>
        				<li><a href="#">Phone: +1234567890</a></li>
        				<li><a href="#"></a></li>
        			</ul>
        		</div>
        	</div>
        	<div class="col-lg-3 col-md-3 col-sm-6">
        		<div class="column">
        			<h4>Follow Us</h4>
        			<ul class="social">
        				<li><a href="#">Google Plus</a></li>
        				<li><a href="#">Facebook</a></li>
        				<li><a href="#">Twitter</a></li>
        				<li><a href="<%=request.getContextPath() %>/login">Login</a></li>
        			</ul>
        		</div>
        	</div>
        </div>
        <div class="navbar-inverse text-center copyright">
        	Copyright © 2015 Damy All right reserved
        </div>
    </footer>
    
    
    <!-- JS -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.bxslider.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/jquery.blImageCenter.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/mimity.js"></script>
    
    <!-- jQuery Validation  -->
	<script src="<%=request.getContextPath()%>/resources/jquery-validation/jquery.validate.min.js"></script>
    
    <script type="text/javascript">
		$('.btn-option').click(function() {
			var option = $(this).siblings('input.a-hidden-opt').val();
			$('#hidden-option').val(option);
			$('#form-search').submit();
		});
	</script>
    
    <!--javascript-source attribute  -->
	<tiles:insertAttribute name="javascript-source"></tiles:insertAttribute>
	
</body>
</html>