/**
 * 管理员界面脚本
 */
var LOADFLAG1 = false;
var LOADFLAG2 = false;
$('#f1').click(function(){  //认证请求管理
	$('#bc').text("  / 认证请求管理");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#midreq').show();
	
});
$('#f2').click(function(){  //用户身份认证
	$('#bc').text("  / 用户身份认证");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#hanreq').show();
	if(!LOADFLAG2){
		$.ajax({
			type : "post",
			url : "loadrequest0",
			dataType : "json",
			contentType : "application/json",
			success : function(data){		
				$.each(data, function(){
					var tr = document.createElement("tr");
					var td1 = document.createElement("td");
					var td2 = document.createElement("td");
					var td3 = document.createElement("td");
					var form = document.createElement("form");
					var bn = document.createElement("button");
					var i1 = document.createElement("input");
					var i2 = document.createElement("input");
					var i3 = document.createElement("input");
					$(bn).attr("class", "btn btn-primary");
					$(bn).text("认证");
					$(i1).attr("name", "identity.id");
					$(i1).attr("class", "minput");
					$(i1).attr("value", this.identity["id"]);
					$(i2).attr("name", "user.id");
					$(i2).attr("class", "minput");
					$(i2).attr("value", this.user["id"]);
					$(i3).attr("name", "id");
					$(i3).attr("class", "minput");
					$(i3).attr("value", this.id);
					$(td1).text(this.user["username"]);
					$(td2).text(this.identity["name"]);
					$(form).attr("action", "identityuser");
					$(form).attr("method", "post");
					form.append(i1);
					form.append(i2);
					form.append(i3);
					form.append(bn);
					td3.append(form);
					tr.append(td1);
					tr.append(td2);
					tr.append(td3);
					$('#hanreqbody').append(tr);
					LOADFLAG2 = true;
				})
			},
			error : function(e){
				alert("失败");
				console.log(e);
			}
		});
	}
	
});
$('#f3').click(function(){  //权限关系
	$('#bc').text("  / 权限关系");
	$('.mdiv').hide();
	$('.mi').hide();
	$('#idpow').show();
	
});