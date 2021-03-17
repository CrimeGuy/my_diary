package com.liutao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liutao.bean.DayBean;
import com.liutao.bean.UserBean;
import com.liutao.common.DayBoxCommon;
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
	@ResponseBody
	public Map<String,String> Login(UserBean user,HttpSession session) throws Exception {
		user = loginService.findUserByUserMail(user.getUserMail(),user.getUserPwd());
		System.out.println(user);
		Map<String,String> jsonMap = new HashMap<String, String>();
		if(user != null) {
			// 存入session
			session.setAttribute("userInfo", user);
			
			// 账号密码正确 存redis
			RedisUtil redisUtil = new RedisUtil();
			Jedis jedis = redisUtil.getInstence();
			jedis.set(user.getUserMail(), user.getUserId() + "");
			// 判断该用户是否生成当月day_box
			Map<String , Integer> dayMsgMap = DayBoxCommon.getDayMsg();
			Boolean isHasBoxData = loginService.judgeBoxExist(dayMsgMap,user.getUserId());
			System.out.println("box是否生成" + isHasBoxData);
			if(!isHasBoxData) {
				System.out.println("box尚未生成");
				//未生成
				List<DayBean> dayBoxDataList = DayBoxCommon.DayBoxDataCreate(user.getUserId());
				Boolean isSuccess = loginService.createDayBox(dayBoxDataList);
				if(!isSuccess) {
					jsonMap.put("code","500");
					jsonMap.put("status","sysError");
				}
			}
			
			jsonMap.put("code","200");
			jsonMap.put("status","success");
		}else {
			jsonMap.put("code","400");
			jsonMap.put("status","failed");
		}
		
		return jsonMap;	
	}
	
	
	
	@RequestMapping("/anotherPage")
	public ModelAndView AnotherPageInit() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("another_page.tiles");
		return modelAndView;
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
