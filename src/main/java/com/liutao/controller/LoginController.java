package com.liutao.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liutao.bean.UserBean;
import com.liutao.service.LoginService;
import com.liutao.service.UserService;
import com.liutao.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	LoginService loginService;
	@Autowired
	UserService UserService;
	
	@RequestMapping("/userLogin")
	public String Login(UserBean user) throws IOException {
		user = loginService.findUserByUserMail(user.getUserMail(),user.getUserPwd());
		System.out.println(user);
		if(user != null) {
			RedisUtil redisUtil = new RedisUtil();
			Jedis jedis = redisUtil.getInstence();
			jedis.set(user.getUserMail(), user.getUserMail());
			return "/page/main_page.jsp";
		}else {
			return "index.jsp";
		}
		
	}
	
	@RequestMapping("/userRegiste")
	public String registe() {
		UserBean user = new UserBean();
		user.setUserName("����");
		user.setUserPwd("123456");
		System.out.println(UserService.userRegist(user) + "");
		return "";
	}
	
}
