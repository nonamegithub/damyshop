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
						<li><a href="<%=request.getContextPath() %>/home" class="active"
							>Home</a></li>
						<li><a
							href="<%=request.getContextPath() %>/catalogue">Catalogue</a></li>
						<li><a
							href="<%=request.getContextPath() %>/cart">Shopping
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

				<!-- Slider -->
				<div class="col-lg-9 col-md-12">
					<div class="slider">
						<div class="bx-wrapper" style="max-width: 100%;">
							<div class="bx-viewport" aria-live="polite"
								style="width: 100%; overflow: hidden; position: relative; height: 350px;">
								<ul class="bxslider"
									style="width: 3215%; position: relative; transition-duration: 0s; transform: translate3d(-838px, 0px, 0px);">
									<li
										style="float: left; list-style: none; position: relative; width: 838px;"
										class="bx-clone" aria-hidden="true"><a
										href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide1.jpg" alt="">
									</a></li>
									<li
										style="float: left; list-style: none; position: relative; width: 838px;"
										aria-hidden="false"><a
										href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide2.jpg" alt="">
									</a></li>
									<li aria-hidden="true"
										style="float: left; list-style: none; position: relative; width: 838px;">
										<a href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide3.jpg" alt="">
									</a>
									</li>
									<li
										style="float: left; list-style: none; position: relative; width: 838px;"
										aria-hidden="true"><a
										href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide4.jpg" alt="">
									</a></li>
									<li
										style="float: left; list-style: none; position: relative; width: 838px;"
										class="bx-clone" aria-hidden="true"><a
										href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide5.jpg" alt="">
									</a></li>
									<li
										style="float: left; list-style: none; position: relative; width: 838px;"
										class="bx-clone" aria-hidden="true"><a
										href="#"> <img
											src="<%=request.getContextPath() %>/resources/images/slide/slide6.jpg" alt="">
									</a></li>
								</ul>
							</div>
							<div class="bx-controls bx-has-controls-direction">
								<div class="bx-controls-direction">
									<a class="bx-prev" href="">Prev</a><a class="bx-next" href="">Next</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Slider -->

				<!-- Product Selection, visible only on large desktop -->
				<div class="col-lg-3 visible-lg">
					<div class="row text-center">
						<%
							SanPham productSelection = (SanPham) request.getAttribute("productSelection");
							if (productSelection == null) {
								productSelection = new SanPham();
							}
						%>
						<div class="col-lg-12 col-md-12 hero-feature">
							<div class="thumbnail">
								<a href="<%=request.getContextPath() %>/detail?productCode=<%=productSelection.getMaSanPham() %>"
									class="link-p first-p"
									style="overflow: hidden; position: relative;"> <img
									src="<%=MyUtils.getImageURL(request, productSelection.getAnh()) %>" alt=""
									style="position: absolute; width: 250px; height: auto; max-width: none; max-height: none; left: 0px; top: 0px;">
								</a>
								<div class="caption prod-caption">
									<h4>
										<a href="<%=request.getContextPath() %>/detail?productCode=<%=productSelection.getMaSanPham() %>">
										<%=productSelection.getTen() %></a>
									</h4>
									<p><%=MyUtils.shortString(productSelection.getMoTa()) %></p>
									<p></p>
									<div class="btn-group">
										<a href="<%=request.getContextPath() %>/detail?productCode=<%=productSelection.getMaSanPham() %>"
											class="btn btn-default"><%=productSelection.getGia() %> VNĐ</a> <a
											href="<%=request.getContextPath() %>/detail?productCode=<%=productSelection.getMaSanPham() %>"
											class="btn btn-primary"><i class="fa fa-shopping-cart"></i>
											Mua</a>
									</div>
									<p></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End Product Selection -->
			</div>

			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12">

					<!-- Categories -->
					<div class="col-lg-12 col-md-12 col-sm-6">
						<div class="no-padding">
							<span class="title">Thể loại</span>
						</div>

						<div id="main_menu">
							<div class="list-group panel panel-cat">
								<%
									// lay danh sach the loai
									@SuppressWarnings("unchecked")
									ArrayList<LoaiSanPham> categoriesList = (ArrayList<LoaiSanPham>)request.getAttribute("categoriesList");
									if (categoriesList == null || !(categoriesList.size() > 0)) {
										%>
											<a href="#" class="list-group-item">Không có thể loại nào</a>
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
													<img src="<%= MyUtils.getImageURL(request, sp.getAnh()) %>" alt=""
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

				<!-- Featured -->
				<div class="col-lg-9 col-md-9 col-sm-12">
					<div class="col-lg-12 col-sm-12">
						<span class="title">Sản phẩm nổi bật</span>
					</div>
						<%
						@SuppressWarnings("unchecked")
						ArrayList<SanPham> featuredProductList = (ArrayList<SanPham>)request.getAttribute("featuredProductList");
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
					

				</div>
				<!-- End Featured -->

				<div class="clearfix visible-sm"></div>

				<!-- Adidas Category -->
				<div class="col-lg-9 col-md-9 col-sm-12">
					<div class="col-lg-12 col-sm-12">
						<span class="title">DAMY</span>
					</div>
					<%
					@SuppressWarnings("unchecked")
						ArrayList<SanPham> bestSellerProductList = (ArrayList<SanPham>)request.getAttribute("bestsellerProductList");
						if (featuredProductList == null || featuredProductList.size() == 0) {
							%>
							<div class="col-lg-4 col-sm-4 hero-feature">
								<p>Không có sản phẩm nào !</p>
							</div>
							<%
						} else {
							for (SanPham sp : bestSellerProductList) {
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
														href="#"
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
				<!-- End Adidas Category -->

			</div>
		</div>


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>