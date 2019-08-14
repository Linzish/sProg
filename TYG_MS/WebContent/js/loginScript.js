/**
 * 登录脚本
 */
$('#adminlogin').click(function(){
	$("#userForm").css("display", "none");
	$("#adminForm").css("display", "block");
});
$('#userlogin').click(function(){
	$("#adminForm").css("display", "none");
	$("#userForm").css("display", "block");
});