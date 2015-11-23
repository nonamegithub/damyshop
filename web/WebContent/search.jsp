<%@page import="com.bansach.utils.MyUtils"%>
<%@page import="com.bansach.model.bean.SanPham"%>
<%@page import="com.bansach.model.bean.LoaiSanPham"%>
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
							href="<%=request.getContextPath() %>/cart">Shopping
								Cart</a></li>
						<li><a
							href="<%=request.getContextPath() %>/checkout">Checkout</a></li>
						<li><a href="<%=request.getContextPath() %>/search" class="active">Search</a></li>
						
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navigation -->
		
		<div class="container main-container">
        <div class="row">
        	<div class="col-lg-3 col-md-3 col-sm-12">

        		<!-- Categories -->
        		<div class="col-lg-12 col-md-12 col-sm-6">
	        		<div class="no-padding">
	            		<span class="title"><%="Thể loại" %></span>
	            	</div>
					<div id="main_menu">
                        <div class="list-group panel panel-cat">
                            <%
									// lay danh sach the loai
									@SuppressWarnings("unchecked")
									ArrayList<LoaiSanPham> categoriesList = (ArrayList<LoaiSanPham>)request.getAttribute("categoriesList");
									if (categoriesList == null || !(categoriesList.size() > 0)) {
										%>
											<a href="<%=request.getContextPath() %>/catalogue" class="list-group-item">Không có thể loại nào</a>
										<%
									} else {
										for (LoaiSanPham lsp : categoriesList) {
										%>
											<a href="<%=request.getContextPath() %>/catalogue?ctgCode=<%=lsp.getMaLoai() %>" class="list-group-item"><%=lsp.getTen() %></a>
										<%
										}
									}
								%>
                        </div>
                    </div>
				</div>
				<!-- End Categories -->

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

			<!-- Catalogue -->
        	<div class="col-lg-9 col-md-9 col-sm-12">
        		<div class="col-lg-12 col-sm-12">
            		<span class="title">Tìm kiếm cho: "<%=request.getAttribute("query") == null || request.getAttribute("query").toString().length() == 0 ? "Tất cả" : request.getAttribute("query") %>"</span>
            	</div>
            	
            	<%		
            			@SuppressWarnings("unchecked")
						ArrayList<SanPham> featuredProductList = (ArrayList<SanPham>)request.getAttribute("productList");
						if (featuredProductList == null || featuredProductList.size() == 0) {
							%>
							<div class="col-lg-4 col-sm-4 hero-feature">
								<p>Không có sản phẩm nào !</p>
							</div>
							<%
						} else {
							for (SanPham sp : featuredProductList) {
								%>
									<div class="col-lg-4 col-sm-4 hero-feature text-center">
										<div class="thumbnail">
											<a href="<%=request.getContextPath() %>/detail?productCode=<%=sp.getMaSanPham() %>"
												class="link-p" style="overflow: hidden; position: relative;">
												<img src="<%=MyUtils.getImageURL(request, sp.getAnh()) %>" alt=""
												style="position: absolute; width: 250px; height: auto; max-width: none; max-height: none; left: -4px; top: 0px;">
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
            	
	            <!-- <div class="col-lg-4 col-sm-4 hero-feature text-center">
	                <div class="thumbnail">
	                	<a href="detail.html" class="link-p">
	                    	<img src="images/product-2.jpg" alt="">
	                	</a>
	                    <div class="caption prod-caption">
	                        <h4><a href="detail.html">Age Of Wisdom Tan Graphic Tee</a></h4>
	                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut, minima!</p>
	                        <p>
	                        	<div class="btn-group">
		                        	<a href="#" class="btn btn-default">$ 122.51</a>
		                        	<a href="#" class="btn btn-primary"><i class="fa fa-shopping-cart"></i> Mua</a>
	                        	</div>
	                        </p>
	                    </div>
	                </div>
	            </div> -->
	            
	            
				<!-- <div class="text-center">
		        	<ul class="pagination catalogue-pagination">
						<li class="disabled"><a>First</a></li>
						<li class="disabled"><a>Prev</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">Next</a></li>
						<li><a href="#">Last</a></li>
					</ul>
				</div> -->
        	</div>
        	<!-- End Catalogue -->


        </div>
	</div>


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>