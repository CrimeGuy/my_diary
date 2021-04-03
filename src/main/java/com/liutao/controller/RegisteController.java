package com.liutao.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liutao.bean.UserBean;
import com.liutao.common.MailCommon;
import com.liutao.service.UserService;
import com.liutao.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("registe")
public class RegisteController {

	@Autowired
	UserService userService;

	@RequestMapping("/authCode")
	@ResponseBody
	public Map<String, String> sendAuthCode(String registeUserMail) throws Exception {

		Map<String, String> jsonMap = new HashMap<String, String>();
		// 1.生成4位验证码
		Random random = new Random();
		int authCode = random.nextInt(9000) + 1000;
		System.out.println("随机码为----------------->" + authCode);
		// 2.将验证码存入redis中 并设置过去时间5分钟
		RedisUtil redisUtil = new RedisUtil();
		Jedis jedis = redisUtil.getInstence();
		// 如果验证码已经设置 先删除 再设置
		jedis.del("auth_code" + registeUserMail);
		jedis.set("auth_code" + registeUserMail, authCode + "", "NX", "EX", 300);

		// 3.发送验证码
		MailCommon sendMail = new MailCommon();
		sendMail.sendMail(registeUserMail, "registe", authCode + "");
		jsonMap.put("code", "200");
		jsonMap.put("status", "success");
		return jsonMap;
	}

	@RequestMapping("/userRegiste")
	@ResponseBody
	public Map<String, String> registe(String userPwd, String reUserPwd, String registeUserMail, String authCode)
			throws IOException {
		Map<String, String> jsonMap = new HashMap<String, String>();
		// 判空处理
		if (StringUtils.isEmpty(registeUserMail)) {
			// 验证码过期
			jsonMap.put("code", "302");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "请输入邮箱");
			return jsonMap;
		} else if (StringUtils.isEmpty(userPwd)) {
			jsonMap.put("code", "303");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "请输入密码");
			return jsonMap;
		} else if (StringUtils.isEmpty(reUserPwd)) {
			jsonMap.put("code", "304");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "请输入确认密码");
			return jsonMap;
		} else if (StringUtils.isEmpty(authCode)) {
			jsonMap.put("code", "305");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "请输入验证码");
			return jsonMap;
		}

		// 判断邮箱是否重复
		Boolean mailFlag = userService.judgeMailExsit(registeUserMail);

		if (mailFlag) {
			// 验证码过期
			jsonMap.put("code", "306");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "邮箱已被使用");
			return jsonMap;
		}

		// 1.从redis中取出当前注册邮箱所对应的验证码并进行验证
		RedisUtil redisUtil = new RedisUtil();
		Jedis jedis = redisUtil.getInstence();
		String authCodeFromRedis = jedis.get("auth_code" + registeUserMail);
		System.out.println("authCodeFromRedis==================>" + authCodeFromRedis);
		if (StringUtils.isEmpty(authCodeFromRedis)) {
			// 验证码过期
			jsonMap.put("code", "307");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "验证码已过期，请重新获取验证码");
			return jsonMap;
		} else if (!authCodeFromRedis.equals(authCode)) {
			// 验证码错误
			jsonMap.put("code", "308");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "验证码错误");
			return jsonMap;
		}

		// 2.对比两个密码是否一致
		if (!userPwd.equals(reUserPwd)) {
			// 两次秘密不一致
			jsonMap.put("code", "309");
			jsonMap.put("status", "success");
			jsonMap.put("msg", "两次密码不一致");
			return jsonMap;
		}
		// 3.上述验证通过后进行数据库操作
		UserBean user = new UserBean();
		user.setUserName(registeUserMail);
		user.setUserPwd(userPwd);
		user.setUserMail(registeUserMail);
		System.out.println(userService.userRegist(user) + "");
		jsonMap.put("code", "200");
		jsonMap.put("status", "success");
		return jsonMap;
	}
}
