/**
 * 主页面脚本
 */
var identityName;
var identityId;
var idflag = false;
var ggflag = false;
var odflag = false;
var mggflag = false;
$(document).ready(function(){
	//加载用户身份信息，用于权限控制
	$.ajax({
		type : "post",
		url : "useridentity",
		dataType : "json",
		contentType : "application/json",
		success : function(data){
			identityName = data.name;
			identityId = data.id;
		},
		error : function(e){
			alert("错误");
			console.log(e);
		}
	});
});
$('#about').click(function(){
	alert("请联系13047090958");
});
$('#f7').click(function(){  //公告管理
	if(identityId == 1 || identityId == 2){
		alert("抱歉，你没有权限!");
	} else {		
		$('#bc').text("  / 公告管理");
		$('.mdiv').hide();
		$('.mi').hide();
		$('#m_gg').show();
		if(!mggflag){
			$.ajax({
				type : "post",
				url : "usersmessage",
				dataType : "json",
				contentType : "application/json",
				success : function(data){
					$.each(data, function(){
						var tr = document.createElement("tr");
						var td1 = document.createElement("td");
						var td2 = document.createElement("td");
						var a1 = document.createElement("a");
						$(a1).text(this.title);
						$(a1).attr("href", "#");
						$(a1).attr("id", this.id + "msg");
						$(a1).attr("data-toggle", "modal");
						$(a1).attr("data-target", "#m_showmsg");
						$(a1).attr("onclick", "m_clickmsg(this)");
						$(td1).append(a1);
						$(td2).text(this.pDate);
						tr.append(td1);
						tr.append(td2);
						$('#m_msgbody').append(tr);
						mggflag = true;
					});
				},
				error : function(e){
					alert("失败");
					console.log(e);
				}
			});
		}
	}
});
$('#f6').click(function(){ //公告发布
	if(identityId == 1 || identityId == 2){
		alert("抱歉，你没有权限!");
	} else {		
		$('#bc').text("  / 公告发布");
		$('.mdiv').hide();
		$('.mi').hide();
		$('#m_public').show();
	}
});
$('#m1').click(function(){ //场地管理
	if(identityId == 3 || identityId == 6){
		$('#bc').text("  / 场地管理");
		$('.mdiv').hide();
		$('.mi').hide();
		if($('#m10').css("display")=="block"){
			$('#m10').hide();
		}else{
			$('.mul').hide();
			$('#m10').show();
		}
		$('#m_cd').show();
	} else {
		alert("抱歉，你没有权限!");
	}
});
$('#m2').click(function(){ //赛事管理
	if(identityId == 4 || identityId == 6){
		$('#bc').text("  / 赛事管理");
		$('.mdiv').hide();
		$('.mi').hide();
		if($('#m20').css("display")=="block"){
			$('#m20').hide();
		}else{
			$('.mul').hide();
			$('#m20').show();
		}
		$('#m_ss').show();
	} else{
		alert("抱歉，你没有权限!");
	}
});
$('#m3').click(function(){ //器材管理
	if(identityId == 4 || identityId == 6){
		$('#bc').text("  / 器材管理");
		$('.mdiv').hide();
		$('.mi').hide();
		if($('#m30').css("display")=="block"){
			$('#m30').hide();
		}else{
			$('.mul').hide();
			$('#m30').show();
		}
		$('#m_qc').show();
	} else{
		alert("抱歉，你没有权限!");
	}
});
$('#f1').click(function(){  //用户详细信息
	$('#bc').text("  / 用户详细信息");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#userdetail').show();
	$.ajax({
		type : "post",
		url : "userdetail",
		dataType : "text",
		contentType : "application/json",
		success : function(data){
			var detail = $("#detailform input");
			try {
				var d = $.parseJSON(data);
				var d1 = d[0];
				$.each(d1, function(key){
				    $.each(detail, function(index, ele){
						if(ele.name == key){
							ele.value = d1[key];
						}
					});
				});	
				$('#detailform').attr('action', "modifydetail");
			} catch(err){
				console.log(err);
				alert("当前用户没有添加详细信息");
				$('#detailform').attr('action', "useradddetail");
			}
		},
		error : function(e){
			alert("错误");
			console.log(e);
		}
	});
});
$('#f2').click(function(){  //用户身份认证
	$('#bc').text("  / 用户身份认证");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#reqid').show();
	//加载身份信息
	if(!idflag){
		$.ajax({
			type : "post",
			url : "loadidentity",
			dataType : "json",
			contentType : "application/json",
			success : function(data){			
				try {
					$.each(data, function(){
						var optionf = document.createElement("option");
						$(optionf).val(this.id);
						$(optionf).text(this.name);
						$('#selectid').append(optionf);
						idflag = true;
					});
				} catch(err){
					alert("失败");				
				}
			},
			error : function(e){
				alert("错误");
				console.log(e);
			}
		});
	}
});
$('#f3').click(function(){  //修改密码
	$('#bc').text("  / 修改密码");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#mpass').show();
});
$('#f4').click(function(){  //场地预约
	$('#bc').text("  / 场地预约");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#order').show();
	if(!odflag){
		$.ajax({
			type : "post",
			url : "loadorder",
			dataType : "json",
			contentType : "application/json",
			success : function(data){
				$.each(data, function(){
					var tr = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var td4 = document.createElement("td");
					$(td1).text(this.number);
					$(td2).text(this.orderDetail.desc);
					$(td3).text(this.rDate);
					if(this.state == 0){
						$(td4).text("待完成");
					} else {
						$(td4).text("已完成");
					}
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					tr.append(td4);
					$('#orderbody').append(tr);
					odflag = true;
				});
			},
			error : function(e){
				alert("失败");
				console.log(e);
			},
		});
	}
});
$('#f5').click(function(){  //公告栏
	$('#bc').text("  / 公告栏");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#message').show();
	if(!ggflag){
		$.ajax({
			type : "post",
			url : "loadmessage",
			dataType : "json",
			contentType : "application/json",
			success : function(data){
				$.each(data, function(){
					var tr = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var a1 = document.createElement("a");
					$(a1).text(this.title);
					$(a1).attr("href", "#");
					$(a1).attr("id", this.id + "msg");
					$(a1).attr("data-toggle", "modal");
					$(a1).attr("data-target", "#showmsg");
					$(a1).attr("onclick", "clickmsg(this)");
					$(td1).append(a1);
					$(td2).text(this.pDate);
					tr.append(td1);
					tr.append(td2);
					$('#msgbody').append(tr);
					ggflag = true;
				});
			},
			error : function(e){
				alert("失败");
				console.log(e);
			}
		});
	}
});
function clickmsg(param){
	var id = parseInt(param.id);
	var data = {id : id};
	$.ajax({
		type : "post",
		url : "loadmessagebyid",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(data){
			$('#msgtitle').text(data.title);
			$('#msg').val(data.msg);
		},
		error : function(e){
			alert("失败");
			console.log(e);
		}
	});
}
function m_clickmsg(param){
	var id = parseInt(param.id);
	var data = {id : id};
	$.ajax({
		type : "post",
		url : "loadmessagebyid",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(data){
			$('#m_msgtitle').val(data.title);
			$('#m_msg').val(data.msg);
			$('#m_pDate').val(data.pDate);
			$('#m_msgid').val(data.id);
		},
		error : function(e){
			alert("失败");
			console.log(e);
		}
	});
}