package com.liutao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liutao.bean.UserBean;
import com.liutao.service.LoginService;
import com.liutao.service.UserService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	UserService UserService;
	
	@RequestMapping("/userLogin")
	public String Login(UserBean user) {
		user = loginService.findUserByUserName(user.getUserName(),user.getUserPwd());
		System.out.println(user);
		if(user != null) {
			
			return "/page/main_page.jsp";
		}else {
			return "index.jsp";
		}
		
	}
	
	@RequestMapping("/userRegiste")
	public String registe() {
		UserBean user = new UserBean();
		user.setUserName("¡ıÃŒ");
		user.setUserPwd("123456");
		System.out.println(UserService.userRegist(user) + "");
		return "";
	}
	
}
