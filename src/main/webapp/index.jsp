<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login For Diary</title>
<link rel="stylesheet" type="text/css" href="assets/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css?1.0.2">
</head>
<body>
	<script src="assets/layui/layui.js">
</script>
	<script src="assets/js/jquery-1.11.1.js"></script>
	<script src="assets/js/login.js?v1.0.6"></script>

<script type="text/javascript">

</script>




	<div class="layui-main layui-bg-blue">
		
		<form action="login/userLogin.action" id="loginForm" method="post"
			class="layui-form">
			<div style="height: 20px"></div>
			<div class="layui-form-item login-title">welcome</div>
			<div class="layui-form-item user-name">
				<label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
				<div class="layui-input-block">
					<input type="text" id="userMail" name="userMail" placeholder="请输入用户名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item user-password">
				<label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
				<div class="layui-input-block">
					<input type="password" id="userPwd" name="userPwd" placeholder="请输入密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div id="login-error-msg"></div>
			<div class="login-btn">
				<button type="button" id="loginBtn" class="layui-btn layui-btn-warm ">登陆</button>
				<button type="button" id="registeBtn" class="layui-btn layui-btn-warm ">注册</button>
			</div>

		</form>
	</div>






























</body>
</html>