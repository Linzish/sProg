<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>错误</title>
</head>
<body>
抛出的异常信息：${requestScope.ex.message }
<br>
${requestScope.ex.stackTrace }
</body>
</html>