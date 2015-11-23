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
					<a class="navbar-brand visible-xs" href="<%=request.getContextPath() %>/home">Damy Shop</a>
				</div>
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li><a href="<%=request.getContextPath() %>/home"
							>Home</a></li>
						<li><a
							href="<%=request.getContextPath() %>/catalogue">Catalogue</a></li>
						<li><a
							href="<%=request.getContextPath() %>/cart" class="active">Shopping
								Cart</a></li>
						<li><a
							href="<%=request.getContextPath() %>/checkout">Checkout</a></li>
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

        	<div class="clearfix visible-sm"></div>

			<!-- Cart -->
        	<div class="col-lg-9 col-md-9 col-sm-12">
        		<div class="col-lg-12 col-sm-12">
            		<span class="title">SHOPPING CART</span>
            	</div>
	            <div class="col-lg-12 col-sm-12 hero-feature">
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
						<a class="btn btn-primary" href="<%=request.getContextPath() %>/catalogue"><i class="fa fa-arrow-circle-left"></i> Continue Shopping</a>
						<a class="btn btn-primary" href="<%=request.getContextPath() %>/cart">Update Cart</a>
						<a class="btn btn-primary" href="<%=request.getContextPath() %>/checkout">Checkout <i class="fa fa-arrow-circle-right"></i></a>
					</div>

	            </div>
        	</div>
        	<!-- End Cart -->


        </div>
	</div>


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>