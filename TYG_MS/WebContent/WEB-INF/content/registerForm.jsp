<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/registerStyle.css" />
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
	<div class="container" id="registerForm">
		<div class="row align-items-center justify-content-center tocenter">
			<div class="col-xs-6 col-md-4 col-center-block">
				<form class="form-signin" action="register" method="post">
					<h2 class="form-signin-heading">注册</h2>
					<font color="red">${requestScope.message }</font>
					<label for="username" class="sr-only">用户名</label>
					<input type="text" id="username" class="form-control" placeholder="用户名" required autofocus name="username">
					<br>
					<label for="inputPassword" class="sr-only">密码</label>
					<input type="password" id="inputPassword" class="form-control" placeholder="密码" required name="password">
					<br>
					<label for="inputPassword" class="sr-only">确认密码</label>
					<input type="password" id="cfPassword" class="form-control" placeholder="确认密码" required name="cfpassword">
					<br>
					<button class="btn btn-default btn-primary btn-block" type="submit">注册</button>
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
<script src="js/registerScript.js" type="text/javascript"></script>
</body>
</html>