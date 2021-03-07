<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login for mydiary</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<script src="layui/layui.js">
</script>
<script type="text/javascript">
/* layui.use(['layer', 'form'], function(){
  var layer = layui.layer
,form = layui.form;
  
  layer.msg('Hello World');
});
 */
layui.use('form', function(){
	  var form = layui.form;
	  //各种基于事件的操作，下面会有进一步介绍
});
</script>





<div class="layui-main layui-bg-blue">
	
	<form action="login/userLogin.action" method="post" class="layui-form">
		<div style="height: 20px"></div>
		<div class="layui-form-item login-title">
			welcome
		</div>
		<div class="layui-form-item user-name">
		    <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
		    <div class="layui-input-block">
		      <input type="text" name="userMail" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
		    </div>
	 	</div>
	 	<div class="layui-form-item user-password">
		    <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
		    <div class="layui-input-block">
		      <input type="password" name="userPwd" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		    </div>
	 	</div>
	 	<div class="login-btn">
	 		<button type="lay-submit" class="layui-btn layui-btn-warm ">登陆</button>
	 		<button type="button" class="layui-btn layui-btn-warm ">注册</button>
	 	</div>
	 	
 	</form>
</div>






























</body>
</html>