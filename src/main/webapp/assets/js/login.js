		
$(document).ready(function() {
	$('#loginBtn').click(function(){
		$('#login-error-msg').text("");
		$.ajax({
			type: "post",
			url:"login/userLogin.action",
			data:{
				userMail: $("#userMail").val(),
				userPwd: $("#userPwd").val()
			},
			dataType:"json",
			success:function(result){
				if('200' == result.code){
					window.location.href="diary/diaryPageInit.action?mail=" + $("#userMail").val();
				}else{
					$('#login-error-msg').text("账号或密码错误！");
				}
			}
		});
		
	});	
		
});
