<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Homepage</title>
<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath() %>/resources/sb-admin-2/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=request.getContextPath() %>/resources/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Đăng Nhập</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="<%=request.getContextPath()%>/doLogin">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="E-mail" name="username" type="" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" name="password" type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox" value="Remember Me">Remember Me
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<button type="submit" class="btn btn-lg btn-success btn-block">Đăng nhập</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="<%=request.getContextPath() %>/resources/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=request.getContextPath() %>/resources/sb-admin-2/js/sb-admin-2.js"></script>
</body>
</html>