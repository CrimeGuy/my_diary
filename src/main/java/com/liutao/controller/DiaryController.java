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
import com.liutao.service.LoginService;
import com.liutao.util.RedisUtil;

import redis.clients.jedis.Jedis;

@Controller
@RequestMapping("diary")
public class DiaryController {

	@Autowired
	DiaryService diaryService;
	@Autowired
	LoginService loginService;
	
	
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
	public List<DayBean> findDayData(HttpSession session,String monthNo,String yearNo) throws ParseException{
		//登录之后的为当前月份的数据,页面不传月份与年份信息
		int year = 0;
		int month = 0;
		UserBean userInfo = (UserBean) session.getAttribute("userInfo");
		if(StringUtils.isEmpty(monthNo) || StringUtils.isEmpty(yearNo)) {
			// 1.获取当前日期的所有数据（年，月）
			Map<String , Integer> dayMsgMap = DayBoxCommon.getDayMsg(null,null);
			year = dayMsgMap.get("year");
			month = dayMsgMap.get("month");
		}else {
			year = Integer.parseInt(yearNo);
			month = Integer.parseInt(monthNo);
		}
		
		// 2.获取当前用户当月的day数据
		List<DayBean> userDayList = diaryService.findUserDayData(year,month,userInfo.getUserId());
		// 3.如果为空 说明页面上点击上个月 或者 下个月按钮
		if(userDayList.size() == 0) {
			//插入查询月分的day信息
			List<DayBean> dayBoxDataList = DayBoxCommon.DayBoxDataCreate(userInfo.getUserId(),monthNo,yearNo);
			Boolean isSuccess = loginService.createDayBox(dayBoxDataList);
			if(isSuccess) {
				userDayList = diaryService.findUserDayData(year,month,userInfo.getUserId());
			}
		}
		// 3.返回json数据
		return userDayList;
	}
	
	
	
	
	
}
