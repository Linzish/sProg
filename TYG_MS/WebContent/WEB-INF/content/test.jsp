<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
<h3>登录</h3>
<form:form modelAttribute="user" action="login" method="post">
	<font color="red">${requestScope.message }</font>
	<table>
		<tr>
			<td><label>登录名：</label></td>
			<td><form:input path="username"/></td>
			<td><font color="red"><form:errors path="username"/></font></td>
		</tr>
		<tr>
			<td><label>密码：</label></td>
			<td><form:input path="password" type="password"/></td>
			<td><font color="red"><form:errors path="password"/></font></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="登录"></td>
		</tr>
	</table>
</form:form>
<hr>
<form:form modelAttribute="admin" action="adminlogin" method="post">
	<font color="red">${requestScope.message }</font>
	<table>
		<tr>
			<td><label>登录名：</label></td>
			<td><form:input path="username"/></td>
			<td><font color="red"><form:errors path="username"/></font></td>
		</tr>
		<tr>
			<td><label>密码：</label></td>
			<td><form:input path="password"/></td>
			<td><font color="red"><form:errors path="password"/></font></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="登录"></td>
		</tr>
	</table>
</form:form>
<a href="registerform">注册</a>
<br>
<a href="repasswordform">重置密码</a>
<hr>
<h3>注册</h3>
<form:form modelAttribute="user" action="register" method="post">
	<font color="red">${requestScope.message }</font>
	<table>
		<tr>
			<td><label>登录名：</label></td>
			<td><form:input path="username"/></td>
			<td><font color="red"><form:errors path="username"/></font></td>
		</tr>
		<tr>
			<td><label>密码：</label></td>
			<td><form:input path="password"/></td>
			<td><font color="red"><form:errors path="password"/></font></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="注册"></td>
		</tr>
	</table>
</form:form>
<hr>
<h3>重置密码</h3>
<form action="repass" method="post">
	<font color="red">${requestScope.message }</font>
	<table>
		<tr>
			<td><label>登录名：</label></td>
			<td><input name="username" type="text"/></td>
		</tr>
		<tr>
			<td><label>邮箱：</label></td>
			<td><input name="email" type="text"/></td>
		</tr>
		<tr>
			<td><label>新密码：</label></td>
			<td><input name="newPassword" type="text"/></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="提交"></td>
		</tr>
	</table>
</form>
<hr>
<h2>体育馆管理系统</h2>
欢迎【${sessionScope.user_session.username }】用户登录
<form action="usermpass" method="post">
	<font color="red">${requestScope.mpass_message }</font>
	<table>
		<tr>
			<td><label>新密码：</label></td>
			<td><input name="newPassword" type="text"/></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="提交"></td>
		</tr>
	</table>
</form>
<hr>
<form action="userdetail" method="post">
	<input type="button" id=search value="加载">
</form>
<hr>
<form action="identityrequset" method="post">
	<font color="red">${requestScope.identityrequset_message }</font>
	<table>
		<tr>
			<td><label>身份：</label></td>
			<td><input name="identity_id" type="text"/></td>
		</tr>
		<tr>
			<td><input type="submit" id=submit value="提交"></td>
		</tr>
	</table>
</form>
</body>
</html>