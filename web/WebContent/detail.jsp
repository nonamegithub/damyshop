<%@page import="com.bansach.utils.MyUtils"%>
<%@page import="com.bansach.model.bean.SanPham"%>
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
							ArrayList<SanPham> bestsellerProductListLeft = (ArrayList<SanPham>) request
											.getAttribute("bestsellerProductListLeft");
									if (bestsellerProductListLeft == null
											|| bestsellerProductListLeft.size() == 0) {
						%>
						<div class="hero-feature">
							<div class="thumbnail text-center">Không có sản phẩm</div>
						</div>
						<%
							} else {
										for (SanPham sp : bestsellerProductListLeft) {
						%>
						<div class="hero-feature">
							<div class="thumbnail text-center">
								<a
									href="<%=request.getContextPath()%>/detail?productCode=<%=sp.getMaSanPham()%>"
									class="link-p" style="overflow: hidden; position: relative;">
									<img src="<%=MyUtils.getImageURL(request, sp.getAnh())%>"
									alt=""
									style="position: absolute; width: 250px; height: auto; max-width: none; max-height: none; left: -13px; top: 0px;">
								</a>
								<div class="caption prod-caption">
									<h4>
										<a
											href="<%=request.getContextPath()%>/detail?productCode=<%=sp.getMaSanPham()%>"><%=sp.getTen()%></a>
									</h4>
									<p><%=MyUtils.shortString(sp.getMoTa())%></p>
									<p></p>
									<div class="btn-group">
										<a
											href="<%=request.getContextPath()%>/detail?productCode=<%=sp.getMaSanPham()%>"
											class="btn btn-default"><%=sp.getGia()%> VNĐ</a> <a
											href="<%=request.getContextPath()%>/detail?productCode=<%=sp.getMaSanPham()%>"
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

				<%
					SanPham sp = (SanPham) request.getAttribute("sanPham");
							if (sp == null) {
								sp = new SanPham();
							}
				%>
				<!-- Product Detail -->
				<div class="col-lg-9 col-md-9 col-sm-12">
					<div class="col-lg-12 col-sm-12">
						<span class="title"><%=sp.getTen() == null ? "Không có" : sp.getTen()%></span>
					</div>
					<div class="col-lg-12 col-sm-12 hero-feature">

						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6">
								<!-- Main Image -->
								<div class="product-main-image-container">
									<img src="images/loader.gif" alt="" class="product-loader">
									<span class="thumbnail product-main-image"> <img
										src="<%=MyUtils.getImageURL(request, sp.getAnh())%>" alt="">
									</span>
								</div>
								<!-- End Main Image -->

								<!-- Thumbnail Image -->
								<!-- <div class="col-xs-3 product-thumb-image">
								<a href="images/detail1.jpg" class="thumbnail">
									<img src="images/detail1.jpg" alt="">
								</a>
							</div>
							<div class="col-xs-3 product-thumb-image">
								<a href="images/detail2.jpg" class="thumbnail">
									<img src="images/detail2.jpg" alt="">
								</a>
							</div>
							<div class="col-xs-3 product-thumb-image">
								<a href="images/detail3.jpg" class="thumbnail">
									<img src="images/detail3.jpg" alt="">
								</a>
							</div>
							<div class="col-xs-3 product-thumb-image">
								<a href="images/detail1.jpg" class="thumbnail">
									<img src="images/detail1.jpg" alt="">
								</a>
							</div> -->
								<!-- End Thumbnail Image -->
							</div>

							<div class="visible-xs">
								<div class="clearfix"></div>
							</div>

							<div class="col-lg-6 col-md-6 col-sm-6">
								<div class="well product-short-detail">
									<div class="row">
										<div class="the-list">
											<h3 class="col-xs-12">
												<!-- <span class="price-old">$169</span> -->
												<%=sp.getGia() == null ? 0 : sp.getGia()%> VNĐ
											</h3>
										</div>
										<div class="the-list">
											<div class="col-xs-4">Số lượng còn</div>
											<div class="col-xs-8">
												<!-- <span class="red">OUT OF STOCK</span> -->
												<span class="green">100</span>
											</div>
										</div>
										<div class="the-list">
											<div class="col-xs-4">Tác giả</div>
											<div class="col-xs-8">
												<label style="font-weight: bold;"> <%=sp.getTacGia() %>
												</label>
											</div>
										</div>
										<div class="the-list">
											<div class="col-xs-4">Số trang</div>
											<div class="col-xs-8">
												<label> <%=sp.getSoTrang()%>
												</label>
											</div>
										</div>
										<div class="the-list">
											<div class="col-xs-4">Kích thước</div>
											<div class="col-xs-8">
												<label> <%=sp.getKichThuoc() == null ? "" : sp
							.getKichThuoc()%>
												</label>
											</div>
										</div>
										<div class="clearfix"></div>
										<hr />
										<div class="col-xs-12 input-qty-detail">
											<form action="doGioHangThem" method="post">
												<input name="maSanPham" type="hidden"
													value="<%=sp.getMaSanPham()%>" /> <input name="giaSP"
													type="hidden" value="<%=sp.getGia()%>" /> <input
													name="soLuongSp" type="number"
													class="form-control input-qty text-center" value="1">
												<button class="btn btn-default pull-left">
													<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
												</button>
											</form>
										</div>
										<div class="clearfix"></div>
										<br />
										<div class="col-xs-12 add-to-detail">
											<div class="row">
												<div class="col-xs-6">
													<a href="#"><i class="fa fa-list"></i> So sánh</a>
												</div>
												<div class="col-xs-6">
													<a href="#"><i class="fa fa-heart"></i> Thêm vào yêu
														thích</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="clearfix"></div>
							<br clear="all" />

							<div class="col-xs-12 product-detail-tab">
								<!-- Nav tabs -->
								<ul class="nav nav-tabs">
									<li class="active"><a href="#desc" data-toggle="tab">Description</a></li>
									<li><a href="#detail" data-toggle="tab">Detail</a></li>
									<li><a href="#review" data-toggle="tab">Review</a></li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">
									<div class="tab-pane active" id="desc">
										<div class="well">
											<p>
												<%=sp.getMoTa() == null ? "" : sp.getMoTa()%>
											</p>
										</div>
									</div>
									<div class="tab-pane" id="detail">
										<div class="well">
											<table class="table table-bordered">
												<tbody>
													<tr>
														<td width="40%">Tác giả</td>
														<td><%=sp.getTacGia() %></td>
													</tr>
													<tr>
														<td>Nhà xuất bản</td>
														<td><%=sp.getNhaXuatBan() == null ? "" : sp
							.getNhaXuatBan()%></td>
													</tr>
													<tr>
														<td>Số trang</td>
														<td><%=sp.getSoTrang()%></td>
													</tr>
													<tr>
														<td>Kích thước</td>
														<td><%=sp.getKichThuoc() == null ? "" : sp
							.getKichThuoc()%></td>
													</tr>
													<tr>
														<td>Trọng lượng</td>
														<td><%=sp.getTrongLuong()%></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="tab-pane" id="review">
										<div class="well">
											<div class="media">
												<a class="pull-left" href="#"> <img class="media-object"
													alt="64x64"
													src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCI+PHJlY3Qgd2lkdGg9IjY0IiBoZWlnaHQ9IjY0IiBmaWxsPSIjZWVlIi8+PHRleHQgdGV4dC1hbmNob3I9Im1pZGRsZSIgeD0iMzIiIHk9IjMyIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjEycHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9zdmc+">
													<div class="product-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star-half-o"></i>
													</div>
												</a>
												<div class="media-body">
													<h5 class="media-heading">
														<strong>John Thor</strong>
													</h5>
													Cras sit amet nibh libero, in gravida nulla. Nulla vel
													metus scelerisque ante sollicitudin commodo. Cras purus
													odio, vestibulum in vulputate at, tempus viverra turpis.
													Fusce condimentum nunc ac nisi vulputate fringilla. Donec
													lacinia congue felis in faucibus.
												</div>
											</div>
											<div class="media">
												<a class="pull-left" href="#"> <img class="media-object"
													alt="64x64"
													src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCI+PHJlY3Qgd2lkdGg9IjY0IiBoZWlnaHQ9IjY0IiBmaWxsPSIjZWVlIi8+PHRleHQgdGV4dC1hbmNob3I9Im1pZGRsZSIgeD0iMzIiIHk9IjMyIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjEycHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NjR4NjQ8L3RleHQ+PC9zdmc+">
													<div class="product-rating">
														<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
															class="fa fa-star"></i> <i class="fa fa-star-half-o"></i>
														<i class="fa fa-star-o"></i>
													</div>
												</a>
												<div class="media-body">
													<h5 class="media-heading">
														<strong>Michael</strong>
													</h5>
													Cras sit amet nibh libero, in gravida nulla. Nulla vel
													metus scelerisque ante sollicitudin commodo. Cras purus
													odio, vestibulum in vulputate at, tempus viverra turpis.
													Fusce condimentum nunc ac nisi vulputate fringilla. Donec
													lacinia congue felis in faucibus.
												</div>
											</div>
											<hr />
											<h4>Add your review</h4>
											<p></p>
											<form role="form">
												<div class="form-group">
													<input type="text" class="form-control" placeholder="Name">
												</div>
												<div class="form-group">
													<input type="text" class="form-control" placeholder="Email">
												</div>
												<div class="form-group">
													<select class="form-control">
														<option>1 star</option>
														<option>2 stars</option>
														<option>3 stars</option>
														<option>4 stars</option>
														<option>5 stars</option>
													</select>
												</div>
												<div class="form-group">
													<textarea class="form-control" rows="5"
														placeholder="Your Review"></textarea>
												</div>
												<button type="submit" class="btn btn-default">Submit
													Review</button>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- <div class="addthis_toolbox addthis_default_style addthis_32x32_style">
						<a class="addthis_button_preferred_1"></a>
						<a class="addthis_button_preferred_2"></a>
						<a class="addthis_button_preferred_3"></a>
						<a class="addthis_button_preferred_4"></a>
						<a class="addthis_button_compact"></a>
					</div>
					<script type="text/javascript" src="http://s7.addthis.com/js/300/addthis_widget.js#pubid=xa-4f0c254f1302adf8"></script>
	             -->
					</div>
					<div class="clearfix"></div>
					<div class="col-lg-12 col-sm-12">
						<span class="title">RELATED PRODUCTS</span>
					</div>
					<%
						@SuppressWarnings("unchecked")
								ArrayList<SanPham> relatedProductList = (ArrayList<SanPham>) request
										.getAttribute("relatedProductsList");
								if (relatedProductList == null
										|| relatedProductList.size() == 0) {
					%>
					<div class="col-lg-4 col-sm-4 hero-feature">
						<p>Không có sản phẩm nào !</p>
					</div>
					<%
						} else {
									for (SanPham relatedProduct : relatedProductList) {
					%>
					<div class="col-lg-4 col-sm-4 hero-feature text-center">
						<div class="thumbnail">
							<a
								href="<%=request.getContextPath() %>/detail?productCode=<%=relatedProduct.getMaSanPham()%>"
								class="link-p" style="overflow: hidden; position: relative;">
								<img
								src="<%=MyUtils.getImageURL(request,
									relatedProduct.getAnh())%>"
								alt=""
								style="position: absolute; width: 250px; height: auto; max-width: none; max-height: none; left: -4px; top: 0px;">
							</a>
							<div class="caption prod-caption">
								<h4>
									<a
										href="<%=request.getContextPath() %>/detail?productCode=<%=relatedProduct.getMaSanPham()%>"><%=relatedProduct.getTen()%></a>
								</h4>
								<p><%=MyUtils.shortString(relatedProduct
									.getMoTa())%></p>
								<p></p>
								<div class="btn-group">
									<a
										href="<%=request.getContextPath() %>/detail?productCode=<%=relatedProduct.getMaSanPham()%>"
										class="btn btn-default"><%=relatedProduct.getGia()%> VNĐ</a> <a
										href="<%=request.getContextPath() %>/detail?productCode=<%=relatedProduct.getMaSanPham()%>"
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
				<!-- End Product Detail -->


			</div>
		</div>


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
		<script
			src="<%=request.getContextPath()%>/resources/js/bootstrap.touchspin.js"
			type="text/javascript"></script>
		<script
			src="<%=request.getContextPath()%>/resources/js/jquery.zoom.min.js"
			type="text/javascript"></script>
	</tiles:putAttribute>

</tiles:insertTemplate>