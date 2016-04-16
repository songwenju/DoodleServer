<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="registerServlet" method="post">
		<br />用户名：<input type="text" name="userName" /> 
		<br />邮箱：<input type="text" name="email" /> 
		<br />密码：<input type="password"name="pwd" /> 
		<br />再次输入密码：<input type="password" name="rePwd" /> 
		<br /><button type="submit">立即注册</button>
	</form>
</body>
</html>