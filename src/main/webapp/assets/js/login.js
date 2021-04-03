
$(document).ready(function () {
	$('#loginBtn').click(function () {
		$('#login-error-msg').text("");
		$.ajax({
			type: "post",
			url: "login/userLogin.action",
			data: {
				userMail: $("#userMail").val(),
				userPwd: $("#userPwd").val()
			},
			dataType: "json",
			success: function (result) {
				if ('200' == result.code) {
					window.location.href = "diary/diaryPageInit.action?mail=" + $("#userMail").val();
				} else {
					$('#login-error-msg').text("账号或密码错误！");
				}
			}
		});
	});

	$('#registeBtn').click(function () {
		layui.use('layer', function () {
			var layer = layui.layer;

			layer.open({
				btn: ['注册', '取消'],
				btnAlign: 'c',
				yes: function (index, layero) {
					registeData(layer,index);
				},
				title: '注册',
				area: '500px',
				type: 1,
				content: '<div class="layui-form-item user-name">'
					+ '<label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>'
					+ '<div class="layui-input-block">'
					+ '<input type="text" id="registeUserMail" name="registeUserMail" placeholder="请输入邮箱" autocomplete="off" class="layui-input">'
					+ '<div class="errorMsg" id="mailError" style="height: 20px;color:red"></div>'
					+ '</div>'
					+ '</div>'

					+ '<div class="layui-form-item user-password">'
					+ '<label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>'
					+ '<div class="layui-input-block">'
					+ '<input type="password" id="registeUserPwd" name="registeUserPwd" placeholder="请输入密码" autocomplete="off" class="layui-input">'
					+ '<div class="errorMsg" id="userPwdError" style="height: 20px;color:red"></div>'
					+ '</div>'
					+ '</div>'

					+ '<div class="layui-form-item user-password">'
					+ '<label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>'
					+ '<div class="layui-input-block">'
					+ '<input type="password" id="reUserPwd" name="reUserPwd" placeholder="请再次输入密码" autocomplete="off" class="layui-input">'
					+ '<div class="errorMsg" id="userRePwdError" style="height: 20px;color:red"></div>'
					+ '</div>'
					+ '</div>'

					+ '<div class="layui-form-item user-password">'
					+ '<label class="layui-form-label"><i class="layui-icon layui-icon-vercode"></i></label>'
					+ '<div class="layui-input-block">'
					+ '<input type="text" id="authCode" name="authCode" placeholder="请输入认证码" autocomplete="off" class="layui-input">'
					+ '<div class="errorMsg" id="authError" style="height: 20px;color:red"></div>'
					+ '<div class="login-btn" style="float: right;width:106px;margin-top:20px">'
					+ '<button type="button" id="sendAuthCode" onclick="sendCode()" class="layui-btn layui-btn-sm layui-btn-danger">发送验证码</button>'
					+ '</div>'
					+ '</div>'
					+ '</div>'
				/* 
				+  '<div class="login-btn" style="margin-bottom: 20px">'
				+  '<button type="button" class="layui-btn layui-btn-warm">注册</button>'
				+  '<button type="button" class="layui-btn">取消</button>'
				+  '</div>' */
			});
		});
	});
});


function sendCode() {
	$('#sendAuthCode').addClass("layui-btn-disabled");
	$.ajax({
		type: "post",
		url: "registe/authCode.action",
		data: {
			registeUserMail: $("#registeUserMail").val(),
			// userPwd: $("#registeUserPwd").val(),
			// reUserPwd: $("#registeUserPwd").val()
		},
		dataType: "json",
		success: function (result) {
			if ('200' == result.code) {
				layui.use('layer', function () {
					var layer = layui.layer;
					layer.open({
						skin: 'demo-class',
						area: ['200px', '180px'],
						content: "验证码已发送"
					})
				})
				$('#sendAuthCode').removeClass("layui-btn-disabled");
			} else {
			}
		}
	});
};

function registeData(layero,index) {
	var registeUserPwd = $('#registeUserPwd').val();
	var reUserPwd = $('#reUserPwd').val();
	var registeUserMail = $('#registeUserMail').val();
	var authCode = $('#authCode').val();
	$('.errorMsg').text("");
	$.ajax({
		type: "post",
		url: "registe/userRegiste.action",
		data: {
			registeUserMail: registeUserMail,
			userPwd: registeUserPwd,
			reUserPwd: reUserPwd,
			authCode: authCode
		},
		dataType: "json",
		success: function (result) {
			if ('200' == result.code) {
				flag = true;
				layui.use('layer', function () {
					var layer = layui.layer;
					layer.open({
						skin: 'demo-class',
						area: ['200px', '180px'],
						content: "注册成功，请登录！"
					})
				});

				layero.close(index);

			} else if('305' == result.code || '307' == result.code || '308' == result.code){
				$('#authError').text(result.msg);
			}else if('302' == result.code || '306' == result.code){
				$('#mailError').text(result.msg);
			}else if('303' == result.code){
				$('#userPwdError').text(result.msg);
			}else if('304' == result.code || '309' == result.code){
				$('#userRePwdError').text(result.msg);
			}
		}
	});

}
























