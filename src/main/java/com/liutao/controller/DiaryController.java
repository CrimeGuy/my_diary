package com.liutao.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liutao.bean.DayBean;
import com.liutao.bean.UserBean;
import com.liutao.common.DayBoxCommon;
import com.liutao.service.DiaryService;
import com.liutao.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("diary")
public class DiaryController {

	@Autowired
	DiaryService diaryService;
	
	@RequestMapping("/diaryPageInit")
	public ModelAndView MainPageInit(String mail) throws Exception {
		RedisUtil redisUtil = new RedisUtil();
		Jedis jedis = redisUtil.getInstence();
		String userIdStr = jedis.get(mail);
		if(StringUtils.isEmpty(userIdStr)) {
			//TODO
		}
		int userId = Integer.parseInt(userIdStr);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main_page.tiles");
		return modelAndView;
	}
	
	@RequestMapping("/diaryPageData")
	@ResponseBody
	public List<DayBean> findDayData(HttpSession session) throws ParseException{
		
		// 1.获取当前日期的所有数据（年，月）
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");
		Map<String , Integer> dayMsgMap = DayBoxCommon.getDayMsg();
		int year = dayMsgMap.get("year");
		int month = dayMsgMap.get("month");
		// 2.获取当前用户当月的day数据
		List<DayBean> userDayList = diaryService.findUserDayData(year,month,userInfo.getUserId());
		// 3.返回json数据
		return userDayList;
	}
	
	
	
	
	
}
