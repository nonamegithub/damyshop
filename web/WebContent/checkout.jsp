<%@page import="com.bansach.utils.MyUtils"%>
<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.bansach.model.bean.ChiTietGioHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="./templates/template.jsp">

	<!--content  -->
	<tiles:putAttribute name="body">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- text logo on mobile view -->
					<a class="navbar-brand visible-xs"
						href="<%=request.getContextPath() %>/home">Damy Shop</a>
				</div>
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li><a href="<%=request.getContextPath() %>/home"
							>Home</a></li>
						<li><a
							href="<%=request.getContextPath() %>/catalogue">Catalogue</a></li>
						<li><a
							href="<%=request.getContextPath() %>/cart">Shopping
								Cart</a></li>
						<li><a
							href="<%=request.getContextPath() %>/checkout" class="active">Checkout</a></li>
						<li><a href="<%=request.getContextPath() %>/search">Search</a></li>
						
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navigation -->
		
		<div class="container main-container">
        <div class="row">
        	<div class="col-lg-3 col-md-3 col-sm-12">

				<!-- Best Seller -->
				<div class="col-lg-12 col-md-12 col-sm-6">
						<div class="no-padding">
							<span class="title">BEST SELLER</span>
						</div>
						
						<%
							ArrayList<SanPham> bestsellerProductListLeft = (ArrayList<SanPham>) request.getAttribute("bestsellerProductListLeft");
							if (bestsellerProductListLeft == null || bestsellerProductListLeft.size() == 0) {
								%>
									<div class="hero-feature">
										<div class="thumbnail text-center">
											Không có sản phẩm
										</div>
									</div>
								<%
							} else {
								for (SanPham sp : bestsellerProductListLeft) {
									%>
										<div class="hero-feature">
											<div class="thumbnail text-center">
												<a href="<%=request.getContextPath() %>/detail?productCode=<%=sp.getMaSanPham() %>"
													class="link-p" style="overflow: hidden; position: relative;">
													<img src="<%=MyUtils.getImageURL(request, sp.getAnh()) %>" alt=""
													style="position: absolute; width: 250px; height: auto; max-width: none; max-height: none; left: -13px; top: 0px;">
												</a>
												<div class="caption prod-caption">
													<h4>
														<a href="<%=request.getContextPath() %>/detail?productCode=<%=sp.getMaSanPham() %>"><%=sp.getTen() %></a>
													</h4>
													<p><%=MyUtils.shortString(sp.getMoTa()) %></p>
													<p></p>
													<div class="btn-group">
														<a href="<%=request.getContextPath() %>/detail?productCode=<%=sp.getMaSanPham() %>"
															class="btn btn-default"><%=sp.getGia() %> VNĐ</a> <a
															href="<%=request.getContextPath() %>/detail?productCode=<%=sp.getMaSanPham() %>"
															class="btn btn-primary"><i class="fa fa-shopping-cart"></i>
															Mua</a>
													</div>
													<p></p>
												</div>
											</div>
										</div>
									<%
								}
							}
						%>
						
					</div>
				<!-- End Best Seller -->

        	</div>
					
				<!-- Cart -->
			
	        	<div class="col-lg-9 col-md-9 col-sm-12">
	        		<div class="col-lg-12 col-sm-12">
	            		<span class="title">CHECKOUT</span>
	            	</div>					
	            	
	            	<form id="form-checkout" action="doCheckout" method="post"> 
		            <div class="col-lg-12 col-sm-12 hero-feature">
		            
		            <!-- Message -->
		            <%
		            	String msg = request.getParameter("msg");
		            	String err = request.getParameter("err");
		            	
		            	if (msg != null) {
		            		%>
		            			
		            			<div class="alert alert-success" role="alert">
								<button type="button" class="close" data-dismiss="alert">x</button>
								  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
								  <span class="sr-only">Thông báo:</span>
								  <%=msg %>
								</div>
		            			
		            		<%
		            	}
		            	
		            	if (err != null) {
		            		%>	
		            			
		            			<div class="alert alert-danger" role="alert">
								<button type="button" class="close" data-dismiss="alert">x</button>
								  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
								  <span class="sr-only">Lỗi:</span>
								  <%=err %>
								</div>
		            			
		            		<%
		            	}
		            %>
		            	
						
						<!-- End Message  -->
						
	                    <div class="table-responsive">
	    					<table class="table table-bordered tbl-checkout">
	    						<tbody>
	                                <tr>
	                                    <td>Tên</td>
	                                    <td>
		                                    <div class="form-group">
		                                        <input type="text" name="ten" class="form-control" />
		                                    </div>
	                                    </td>
	                                    <td>Ngày Sinh</td>
	                                    <td>
	                                    	<div class="form-group">
	                                        	<input type="text" name="ngaySinh" class="form-control" />
                                        	</div>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>Email</td>
	                                    <td>
	                                    	<div class="form-group">
	                                        	<input type="text" name="email" class="form-control" />
                                        	</div>
	                                    </td>
	                                    <td>Số điện thoại</td>
	                                    <td>
	                                    	<div class="form-group">
	                                        	<input type="text" name="soDienThoai" class="form-control" />
                                        	</div>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>Địa Chỉ</td>
	                                    <td colspan="3">
	                                    	<div class="form-group">
	                                        	<textarea name="diaChi" class="form-control"></textarea>
                                        	</div>
	                                    </td>
	                                </tr>
	                                <tr>
	                                    <td>Ghi Chú</td>
	                                    <td colspan="3">
	                                        <textarea name="ghiChu" class="form-control"></textarea>
	                                    </td>
	                                </tr>
	                            </tbody>
	    					</table>
	                    </div>
	                    <div class="table-responsive">
	                        <table class="table table-bordered tbl-cart">
	    						<thead>
	                                <tr>
	                                    <td class="hidden-xs">Image</td>
	                                    <td>Product Name</td>
	                                    <td class="td-qty">Quantity</td>
	                                    <td>Unit Price</td>
	                                    <td>Sub Total</td>
	                                    <td>Remove</td>
	                                </tr>
	                            </thead>
	                            <tbody>
	                            <%
	                            	ArrayList<ChiTietGioHang> ctGioHangList = (ArrayList<ChiTietGioHang>) request.getAttribute("ChiTietGioHangList");
	                            	if (ctGioHangList == null || ctGioHangList.size() == 0) {
	                            		%>
	                            			<tr><td colspan="6">Giỏ hàng trống !</td></tr>
	                            		<%
	                            	} else {
	                            		for (ChiTietGioHang ctgh : ctGioHangList) {
	                            			%>
											<tr>
			                                    <td class="hidden-xs">
			                                        <a href="<%=request.getContextPath()%>/detail?productCode=<%=ctgh.getMaSanPham()%>">
			                                            <img src="<%=MyUtils.getImageURL(request, ctgh.getAnh()) %>" alt="Hang hot" title="" width="47" height="47" />
			                                        </a>
			                                    </td>
			                                    <td><a href="<%=request.getContextPath()%>/detail?productCode=<%=ctgh.getMaSanPham()%>"><%=ctgh.getTenSanPham() %></a>
			                                    </td>
			                                    <td>
			                                        <input type="number" max="10" min="1" name="" value="<%=ctgh.getSoLuong() %>" class="input-qty form-control text-center" />
			                                    </td>
			                                    <td class="price"><%=ctgh.getGia() %> VNĐ</td>
			                                    <td><%=ctgh.getGia().multiply(BigDecimal.valueOf(ctgh.getSoLuong())) %> VNĐ</td>
			                                    <td class="text-center">
			                                    	<form action="doGioHangXoa" method="post">
			                                    		<input name="productCode" type="hidden" value="<%=ctgh.getMaSanPham() %>"/>
			                                    		<button type="submit" class="remove_cart" rel="2">
			                                    			<i class="fa fa-trash-o"></i>
			                                        	</button>
			                                    	</form>
			                                    </td>
			                                </tr>                            				
	                            			<%
	                            		}
	                            	}
	                            %>
	                                <tr>
	                                    <td colspan="4" align="right">Total</td>
	                                    <td class="total" colspan="2"><b><%=request.getAttribute("total") %> VNĐ</b>
	                                    </td>
	                                </tr>
	                            </tbody>
	    					</table>
	                    </div>
						<div class="btn-group btns-cart">
							<button type="submit" class="btn btn-primary">Checkout</button>
						</div>
					</div>
					</form>
		            </div>
				</div>
	        
        	<!-- End Cart -->
			        	
        	</div>

        	<div class="clearfix visible-sm"></div>

			


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
	
		<!-- Validation -->
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-validation-bootstrap-tooltip-master/jquery-validate.bootstrap-tooltip.min.js"></script>
		
		<script type="text/javascript">
			$('#form-checkout').validate({
				rules: {
					ten: {required: true},  
					ngaySinh: {required: true},
					email: {required: true, email: true},
					soDienThoai: {required: true, number: true, minlength: 9, maxlength: 15},
					diaChi: {required: true}
				},
				highlight: function(element) {
		            $(element).closest('.form-group').addClass('has-error');
		        },
		        unhighlight: function(element) {
		            $(element).closest('.form-group').removeClass('has-error');
		        },
				messages: {
					ten: "Vui lòng điền tên.",
					ngaySinh: "Ngày sinh chưa hợp lệ.",
					email: "Email chưa hợp lệ.",
					soDienThoai: "Số điện thoại chưa hợp lệ.",
					diaChi: "Vui lòng điền địa chỉ."
				},
				tooltip_options: {
					ten: {placement:'top', trigger:'hover focus'},
					ngaySinh: {placement:'top', trigger:'hover focus'},
					email: {placement:'top', trigger:'hover focus'},
					soDienThoai: {placement:'top', trigger:'hover focus'},
					diaChi: {placement:'top', trigger:'hover focus'}
				},
			});
		</script>
	
	</tiles:putAttribute>

</tiles:insertTemplate>