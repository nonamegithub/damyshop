<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Homepage</title>

</head>
<body>


	<h3>Home</h3>
	<form action="<%=request.getContextPath() %>/home-admin" method="post">
		<fieldset>
		
			<input name="username" type="text"><br/>
			<input name="password" type="password"><br/> 
			
			<label> <input name="remember" type="checkbox" value="Remember Me">Remember Me</label><br/>
			<input type="submit" value="Login">
		</fieldset>
	</form>

</body>
</html>