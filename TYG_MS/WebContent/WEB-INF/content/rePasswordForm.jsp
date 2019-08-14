<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>重置密码</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/repassStyle.css" />
</head>
<body class="bg">
	<div class="container" id="registerForm">
		<div class="row align-items-center justify-content-center tocenter">
			<div class="col-xs-6 col-md-4 col-center-block">
				<form class="form-signin" action="repass" method="post">
					<h2 class="form-signin-heading">找回密码</h2>
					<font color="red">${requestScope.message }</font>
					<label for="username" class="sr-only">用户名</label>
					<input type="text" id="username" class="form-control" placeholder="请输入用户名" required autofocus name="username">
					<br>
					<label for="email" class="sr-only">邮箱</label>
					<input type="text" id="email" class="form-control" placeholder="请输入邮箱" required name="email">
					<br>
					<label for="newPassword" class="sr-only">请输入新密码</label>
					<input type="password" id="newPassword" class="form-control" placeholder="请输入新密码" required name="newPassword">
					<br>
					<button class="btn btn-default btn-primary btn-block" type="submit">提交</button>
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
<script src="js/repassScript.js" type="text/javascript"></script>
</body>

</html>