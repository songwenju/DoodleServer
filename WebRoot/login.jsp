<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <head>
    <base href="<%=basePath%>">
    
    <title>登录系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<c:url value ='/bootstrap3/css/bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value ='/css/common.css'/>">
	<link rel="stylesheet" href="<c:url value ='/pages/css/user/login.css'/>">
  </head>
  
  <body>
    <div class="container">
    	<div class="row">	
    		<form class="form-horizontal" id="loginForm" method="post" action="loginServlet">
    			<div class="login_title">用户登录</div>
   				<br/>
   				<label for="loginName" class="col-sm-3 control-label" >用户名:</label>
   				<input type="text" name="loginUser" class="form-control" id="loginUser" placeholder="用户名">
   				<br/><br/>
   				<label for="loginPass" class="col-sm-3 control-label" >&nbsp;密&nbsp;&nbsp;码:</label>
   				<input type="password" class="form-control" id="loginPass" name="loginPwd" placeholder="密码">
   				<br/><br/>
				<button type="submit" class="btn btn-primary btn-lg" data-loading-text="登录中..." id="button" autocomplete="off">登录</button>
    		</form>
	    	</div>
    	</div>
  </body>
</html>
