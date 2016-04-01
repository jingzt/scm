/**
 * 用户信息
 */

$(function(){
	$("#modifyNickNameForm").hide();
	$("#modifyPwdForm").validate({
		ignore : "", // 开启hidden验证,1.9版本后默认关闭
		rules : {
			'oldPwd' : {
				required : true,
				remote : {
					type : "POST",
					url : "../user/checkOldPwd.do",
					data : {
						oldPwd : function() {
							return $("input[name='oldPwd']").val();
						}
					}
				}
			},
			'newPwd' : {
				required : true,
				rangelength : [ 6, 10 ]
			},
			'confirmPwd' : {
				required : true,
				equalTo : "#newPwd",
				rangelength : [ 6, 10 ]
			}
		},
		messages:{
			'oldPwd':{
				remote:"原密码不正确"
			}
		},
		submitHandler : function(form) {
			var options = {
				url : "../user/modifyPwd.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功,需要重新登录', function() {
							window.location.href="../loginOut.htm";
						});
					} else {
						$.error(data.msg);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$.warn('服务忙,请稍后再试.');
				}
			};
			$(form).ajaxSubmit(options);
		},
		invalidHandler : function(form, validator) {
			return false;
		}

	});
	
	$("#modifyNickNameForm").validate({
		ignore : "", // 开启hidden验证,1.9版本后默认关闭
		rules : {
			'nickName' : {
				required : true,
				rangelength : [ 2, 10 ]
			}
		},
		submitHandler : function(form) {
			var options = {
				url : "../user/modifyUserInfo.do",
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.success) {
						$.success('操作成功', function() {
							window.location.reload();
						});
					} else {
						$.error(data.msg);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$.warn('服务忙,请稍后再试.');
				}
			};
			$(form).ajaxSubmit(options);
		},
		invalidHandler : function(form, validator) {
			return false;
		}

	});
	
});


function modifyPwd(){
	layer.open({
		type : 1,
		title : '修改密码',
		shadeClose : true,
		shade : 0.5,
		area : [ '400px', '350px' ],
		content : $('#modifyPwd')
	});
}
function modifyNickName(){
	$("#modifyNickNameForm").show();
	$("#modifyNickA").hide();
}