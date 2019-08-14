<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体育馆管理系统（管理员模式）</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/adminStyle.css" />
<script type="text/javascript">
	$(document).ready(function(){
		var msg = "${requestScope.message }";
		if(msg != null && msg != ""){
			alert(msg);
		}
	});
</script>
</head>
<body class="bg">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <a class="navbar-brand" href="#">XX体育馆管理系统（管理员模式）</a>
        <button class="navbar-toggler collapsed" aria-expanded="false" aria-controls="navbarsExampleDefault" aria-label="Toggle navigation" type="button" data-target="#navbarsExampleDefault" data-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>  
         <div class="navbar-collapse collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="loginout">退出登录</a>
                </li>
            </ul>
		</div>           
    </nav>
    <div class="container-fluid main-container">
        <div class="row">
            <div class="col-md-3">
                <div class="container">
                    <div class="row">                       
						<div class="col-md-12 text-left" style="padding-top:12px"><p><a href="javascript:;" class="text-dark" style="text-decoration:none">用户：${sessionScope.user_session.username }</a></p></div>
						<div class="col-md-12 text-left"><p><a href="javascript:;" class="text-dark" style="text-decoration:none">用户身份：系统管理员</a></p></div>
                    </div>               
                    <div class="row">
                        <div class="col-md-12"><hr></div>                    
                        <div class="col-md-12 text-left">
                            <p style="background-color:aquamarine">超级用户操作：</p>
                        </div>                        
                        <div class="col-md-12">
                            <div class="list-group">
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f1">认证请求管理</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f2">用户身份认证</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f3">权限关系</a>                           
                            </div>
                        </div>
                    </div>                                 
                </div>
            </div>
            <div class="col-md-9">
            	<div class="mb"><p id="bc"></p></div>
            	<div class="mi"><h1>欢迎登录XX体育馆管理系统（管理员模式）</h1></div>
            	<div class="mdiv" id="midreq">
            		<h2>认证请求管理</h2>
            		<hr>
            		
            	</div>
            	<div class="mdiv" id="hanreq">
            		<h2>用户身份认证</h2>
            		<hr>
            		<table class="table" id="hanreqtable">            			
						<thead>
							<tr>
								<th>申请者</th>
								<th>申请身份</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="hanreqbody">
							
						</tbody>
					</table>
            	</div>
            	<div class="mdiv" id="idpow">
            		<h2>权限关系</h2>
            		<hr>
            		
            	</div>
            </div>
		</div>
	</div>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/adminmainScript.js" type="text/javascript"></script>
</body>
</html>