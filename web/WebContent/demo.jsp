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
						href="./Home - Mimity_files/Home - Mimity.html">Mimity Online
						Shop</a>
				</div>
				<div class="collapse navbar-collapse navbar-ex1-collapse">
					<ul class="nav navbar-nav">
						<li><a href="home.jsp"
							>Home</a></li>
						<li><a
							href="catalogue.jsp">Catalogue</a></li>
						<li><a
							href="cart.jsp" class="active">Shopping
								Cart</a></li>
						<li><a
							href="checkout.jsp">Checkout</a></li>
						<li class="nav-dropdown"><a
							href="http://demo.18maret.com/demo/mimity/v1.3/index.html#"
							class="dropdown-toggle" data-toggle="dropdown"> Pages <span
								class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/about.html">About
										Us</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/contact.html">Contact
										Us</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/typography.html">Typography</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/detail.html">Product
										Detail</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/compare.html">Compare</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/login.html">Login</a></li>
								<li><a
									href="http://demo.18maret.com/demo/mimity/v1.3/register.html">Register</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- End Navigation -->


	</tiles:putAttribute>

	<!--javascript-source  -->
	<tiles:putAttribute name="javascript-source">
	</tiles:putAttribute>

</tiles:insertTemplate>