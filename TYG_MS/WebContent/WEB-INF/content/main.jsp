<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>体育馆管理系统</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="css/mainStyle.css" />
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
        <a class="navbar-brand" href="#">XX体育馆管理系统</a>
        <button class="navbar-toggler collapsed" aria-expanded="false" aria-controls="navbarsExampleDefault" aria-label="Toggle navigation" type="button" data-target="#navbarsExampleDefault" data-toggle="collapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="navbarsExampleDefault">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">首页</a>
                </li>     
                <li class="nav-item">
                    <a class="nav-link" href="#" id="about">关于</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="loginout">退出登录</a>
                </li>
            </ul>    
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" aria-label="Search" type="text" placeholder="搜索">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
            </form>
        </div>                
    </nav>
    <div class="container-fluid main-container">
        <div class="row">
            <div class="col-md-3">
                <div class="container">
                    <div class="row">                       
						<div class="col-md-12 text-left" style="padding-top:12px"><p><a href="javascript:;" class="text-dark" style="text-decoration:none">用户：${sessionScope.user_session.username }</a></p></div>
                        <div class="col-md-12 text-left"><p><a href="javascript:;" class="text-dark" style="text-decoration:none">用户身份：${sessionScope.user_identity.name }</a></p></div>
                    </div>               
                    <div class="row">
                        <div class="col-md-12"><hr></div>                    
                        <div class="col-md-12 text-left">
                            <p style="background-color:aquamarine">用户操作：</p>
                        </div>                        
                        <div class="col-md-12">
                            <div class="list-group">
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f1">用户详细信息</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f2">用户身份认证</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f3">修改密码</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f4">场地预约</a>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="f5">公告栏<span class="badge">99+</span></a>                                
                            	<a href="javascript:;" class="list-group-item list-group-item-action" id="f6">公告发布</a>
                            	<a href="javascript:;" class="list-group-item list-group-item-action" id="f7">公告管理</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12"><hr></div>
                    <div class="row">
                        <div class="col-md-12 text-left">
                            <p style="background-color:rgb(247, 75, 141)">管理员模式：</p>
                        </div>
                        <div class="col-md-12">
                            <div class="list-group">
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="m1">场地管理</a>
                                <div class="list-group mul" id="m10">
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·1XXXXX</a>                               
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·2XXXXX</a>
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·3XXXXX</a>
                            	</div>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="m2">赛事管理</a>
                                <div class="list-group mul" id="m20">
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·1XXXXX</a>                               
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·2XXXXX</a>
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·3XXXXX</a>
                            	</div>
                                <a href="javascript:;" class="list-group-item list-group-item-action" id="m3">器材管理</a>
                                <div class="list-group mul" id="m30">
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·1XXXXX</a>                               
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·2XXXXX</a>
                                	<a href="javascript:;" class="list-group-item list-group-item-action">&nbsp;&nbsp;·3XXXXX</a>
                            	</div>
                            </div>
                        </div>
                    </div>                   
                </div>
            </div>
            <div class="col-md-9">
            	<div class="mb"><p id="bc"></p></div>
            	<div class="mi"><h1>欢迎登录XX体育馆管理系统</h1></div>
            	<div class="mdiv" id="mpass">
            		<h2>修改密码</h2>
            		<hr>
					<form role="form" action="usermpass" method="post">
					<font color="red">${requestScope.mpass_message }</font>
						<div class="form-group">
							<label for="name">新密码</label>
							<input type="password" class="form-control" id="newPassword" placeholder="请输入新密码" name="newPassword">
							<br>
							<label for="name">再次输入新密码</label>
							<input type="password" class="form-control" id="renewPassword" placeholder="请确认新密码">
						</div>
						<button type="submit" class="btn btn-success">提交</button>
					</form>
            	</div>
            	<div class="mdiv" id="reqid">
            		<h2>用户身份认证</h2>
            		<hr>
            		<form role="form" action="identityrequset" method="post">
					<font color="red">${requestScope.mpass_message }</font>
						<div class="form-group">
							<label for="name">请选择身份</label>													
							<select class="form-control" id="selectid" name="identity_id"> 								
								<option>---请选择---</option> 
							</select>
						</div>
						<button type="submit" class="btn btn-success">提交</button>
					</form>
            	</div>
            	<div class="mdiv" id="userdetail">
            		<h2>用户详细信息</h2>
            		<hr>
            		<form class="form" role="form" action="" method="post" id="detailform">
            			<div class="form-group">
            				<input type="text" class="input-block-level" id="id" placeholder="" name="id" hidden>	
            				<table class="table">
								<tbody>
									<tr>																										
										<td>
											<label for="name">姓名</label>										
											<input type="text" class="input-block-level" id="name" placeholder="" name="name">													
										</td>
										<td>
											<label for="name">学号</label>
											<input type="text" class="input-block-level" id="id_number" placeholder="" name="id_number">
										</td>
										<td>
											
										</td>
									</tr>
									<tr>
										<td>
											<label for="name">性别</label>
											<input type="text" class="input-block-level" id="gender" placeholder="" name="gender">
										</td>
										<td>
											<label for="name">出生日期</label>
											<input type="date" class="input-block-level" id="birthday" placeholder="" name="birthday">
										</td>
										<td>
											<label for="name">注册时间</label>
											<input type="text" class="input-block-level" id="reg_date" placeholder="" name="reg_date" readonly="readonly">	
										</td>
									</tr>
									<tr>
										<td>
											<label for="name">证件类型</label>
											<input type="text" class="input-block-level" id="certificate_type" placeholder="" name="certificate_type">							
										</td>
										<td>
											<label for="name">证件号码</label>
											<input type="text" class="input-block-level" id="certificate_num" placeholder="" name="certificate_num">
										</td>
										<td>
											<label for="name">籍贯</label>
											<input type="text" class="input-block-level" id="nativeplace" placeholder="" name="nativeplace">
										</td>
									</tr>
									<tr>
										<td>
											<label for="name">联系地址</label>
											<input type="text" class="input-block-level" id="address" placeholder="" name="address">
										</td>
										<td>
											<label for="name">联系电话</label>
											<input type="text" class="input-block-level" id="phone_num" placeholder="" name="phone_num">	
										</td>
										<td>
											<label for="name">邮箱</label>
											<input type="text" class="input-block-level" id="email" placeholder="" name="email">	
										</td>
									</tr>
									<tr>
										<td>
											<label for="name">状态</label>
											<input type="text" class="input-block-level" id="state" placeholder="" name="state" readonly="readonly">	
										</td>
										<td></td>
										<td></td>
									</tr>
								</tbody>
							</table>				
						</div>
						<button type="submit" class="btn btn-success">提交</button>
            		</form>
            	</div>
            	<div class="mdiv" id="order">
            		<h2>场地预约</h2>
            		<hr>
            		<table class="table" id="ordertable">            			
						<thead>
							<tr>
								<th>订单号</th>
								<th>订单描述</th>
								<th>预约时间</th>
								<th>状态</th>
							</tr>
						</thead>
						<tbody id="orderbody">
							
						</tbody>
					</table>
            	</div>
            	<div class="mdiv" id="message">
            		<h2>公告栏</h2>
            		<hr>
            		<table class="table" id="msgtable">            			
						<thead>
							<tr>
								<th>公告</th>
								<th>时间</th>
							</tr>
						</thead>
						<tbody id="msgbody">
							
						</tbody>
					</table>
					<!-- 公告窗口 -->
    				<div id="showmsg" class="modal fade">
        				<div class="modal-dialog modal-lg">
            				<div class="modal-content">
                				<div class="modal-body">
                    				<button class="close" data-dismiss="modal" id="l-left">
                        				<span>&times;</span>
                    				</button>
                				</div>
                				<div class="modal-title">
                    				<h2 class="text-left mx-3" id="msgtitle">title</h2>
                				</div>
                				<div class="modal-body">
                    				<textarea class="form-control" rows="3" id="msg">content</textarea>
                				</div>
                				<div class="modal-footer">
                					<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                				</div>
            				</div>
        				</div>
    				</div>
            	</div>
            	<div class="mdiv" id="m_public">
            		<h2>公告发布</h2>
            		<hr>
            		<form action="createmessage" method="post">
            			<div class="form-group">
							<label for="name">公告标题</label>
							<input type="text" class="form-control" id="title" placeholder="请输入标题" name="title">
							<br>
							<label for="name">内容</label>
							<textarea cols="50" rows="10" class="form-control" id="msg" placeholder="请输入内容" name="msg"></textarea>
							<br>
							<label for="name">发布时间</label>
							<input type="date" class="form-control" id="pDate" placeholder="" name="pDate">
						</div>
						<button type="submit" class="btn btn-success">提交</button>
            		</form>
            	</div>
            	<div class="mdiv" id="m_gg">
            		<h2>公告管理</h2>
            		<hr>
            		<table class="table" id="m_msgtable">            			
						<thead>
							<tr>
								<th>公告</th>
								<th>时间</th>
							</tr>
						</thead>
						<tbody id="m_msgbody">
							
						</tbody>
					</table>
					<!-- 公告窗口 -->
    				<div id="m_showmsg" class="modal fade">
        				<div class="modal-dialog modal-lg">
            				<div class="modal-content">
                				<div class="modal-body">
                    				<button class="close" data-dismiss="modal" id="l-left">
                        				<span>&times;</span>
                    				</button>
                				</div>
                				<form action="modifymessage" method="post">
                					<div class="modal-title form-control">
                						<input type="text" class="form-control" id="m_msgtitle" placeholder="" name="title">
                						<input type="text" class="form-control" id="m_msgid" placeholder="" name="id" readonly="readonly" hidden>
                					</div>
                					<div class="modal-body">
                    					<textarea class="form-control" rows="3" id="m_msg">content</textarea>
                    					<br>
                    					<label for="name">发布时间</label>
										<input type="date" class="form-control" id="m_pDate" placeholder="" name="pDate">
                					</div> 
                					<div class="modal-footer">
                						<button type="submit" class="btn btn-success">修改</button>
                						<button type="button" class="btn btn-success">发布</button>
                						<button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                					</div>
                				</form>                				             
            				</div>
        				</div>
    				</div>
            	</div>
            	<div class="mdiv" id="m_cd">
            		<h2>场地管理</h2>
            		<hr>
            	</div>
            	<div class="mdiv" id="m_ss">
            		<h2>赛事管理</h2>
            		<hr>
            	</div>
            	<div class="mdiv" id="m_qc">
            		<h2>器材管理</h2>
            		<hr>
            	</div>
            </div>
		</div>
	</div>
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/mainScript.js" type="text/javascript"></script>
</body>
</html>