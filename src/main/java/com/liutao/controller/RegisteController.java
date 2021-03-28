package com.liutao.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liutao.common.MailCommon;
import com.liutao.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("registe")
public class RegisteController {

	@RequestMapping("/authCode")
	@ResponseBody
	public Map<String,String> sendAuthCode(String registeUserMail) throws Exception{
		
		Map<String,String> jsonMap = new HashMap<String, String>();
		// 1.生成4位验证码
		Random random = new Random();
		int authCode = random.nextInt(9000) + 1000;
		System.out.println("随机码为----------------->" + authCode);
		// 2.将验证码存入redis中 并设置过去时间5分钟
		RedisUtil redisUtil = new RedisUtil();
		Jedis jedis = redisUtil.getInstence();
		// 如果验证码已经设置 先删除 再设置
		jedis.del("auth_code" + registeUserMail);
		jedis.set("auth_code" + registeUserMail, authCode + "","NX", "EX", 300);

		// 3.发送验证码
		MailCommon sendMail = new MailCommon();
		sendMail.sendMail(registeUserMail, "registe", authCode + "");
		jsonMap.put("code","200");
		jsonMap.put("status","success");
		return jsonMap;
	}
}
