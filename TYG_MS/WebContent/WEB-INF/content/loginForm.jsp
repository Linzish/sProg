<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/loginStyle.css" />
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${requestScope.remessage }";
		if(msg != null && msg != ""){
			alert(msg);
		}
	});
</script>
</head>
<body class="bg">
	<div class="title"><h1>XX体育馆管理系统</h1></div>
	<div class="container" id="userForm">
		<div class="row align-items-center justify-content-center login-center">
			<div class="col-xs-6 col-md-4 col-center-block">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a href="#" class="nav-link myactive">用户</a></li>
				<li class="nav-item"><a href="#" class="nav-link" id="adminlogin">管理员</a></li>
			</ul>
				<form class="form-signin" action="login" method="post">
					<h2 class="form-signin-heading">请登录</h2>
					<font color="red">${requestScope.message }</font>
					<label for="username" class="sr-only">用户名</label>
					<input type="text" id="username" class="form-control" placeholder="用户名" required autofocus name="username">
					<br>
					<label for="inputPassword" class="sr-only">密码</label>
					<input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
					<div class="toolsbox">
						<label><input type="checkbox" value="remember-me">记住我 </label>
						<label style="float:right"><a href="repasswordform">找回密码</a></label>
					</div>
					<button class="btn btn-default btn-primary btn-block" type="submit">登录</button>
					<br>
					<div class="row">
						<div class="col-md-6">没有账号？</div>
						<div class="col-md-6"><button class="btn btn-default btn-primary btn-block" type="submit" onclick="window.location.href = 'registerform'">注册</button></div>
					</div>					
				</form>
			</div>
		</div>
	</div>
	<div class="container" id="adminForm">
		<div class="row align-items-center justify-content-center login-center">
			<div class="col-xs-6 col-md-4 col-center-block">
			<ul class="nav nav-tabs">
				<li class="nav-item"><a href="#" class="nav-link" id="userlogin">用户</a></li>
				<li class="nav-item"><a href="#" class="nav-link myactive">管理员</a></li>
			</ul>
				<form class="form-signin" action="adminlogin" method="post">
					<h2 class="form-signin-heading">请登录</h2>
					<font color="red">${requestScope.message }</font>
					<label for="username" class="sr-only">用户名</label>
					<input type="text" id="username" class="form-control" placeholder="管理员用户名" required autofocus name="username">
					<br>
					<label for="inputPassword" class="sr-only">密码</label>
					<input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
					<div class="checkbox">
						<label><input type="checkbox" value="remember-me">记住我 </label>
					</div>
					<button class="btn btn-default btn-primary btn-block" type="submit">登录</button>
				</form>
			</div>
		</div>
	</div>
    <footer>
    	<p>@2019 软件1163 201611701322</p>
    </footer>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/loginScript.js" type="text/javascript"></script>
</body>
</html>