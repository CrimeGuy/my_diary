package com.liutao.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liutao.bean.DayBean;

public class DayBoxCommon {

	public static List<DayBean> DayBoxDataCreate(int userId) throws ParseException {
		// 1.判断当前年份 月份 确定插入数据条数（2月需判断是否为闰年） 2.确定该月一号对应的是星期几
		Map<String , Integer> dayMsgMap = getDayMsg();
		int yearInt = dayMsgMap.get("year");
		int monthDayHas = dayMsgMap.get("monthDayHas");
		int weekInt = dayMsgMap.get("week");
		int monthInt = dayMsgMap.get("month");
		// 2.生成批量插入数据
		List<DayBean> dayBoxDataList = new ArrayList<>();
		int j = 0; 
		for(int i=weekInt;i<monthDayHas+weekInt;i++) {
			if(dayBoxDataList.size() >= monthDayHas) {
				break;
			}
			j++;
			if(i > 7) {
				i = 1;
			}
			DayBean dayData = new DayBean(yearInt,i,monthInt,j,userId);
			dayBoxDataList.add(dayData);
		}
		System.out.println(dayBoxDataList);
		return dayBoxDataList;
	}

	
	public static Map<String,Integer> getDayMsg() throws ParseException {
		Map<String, Integer> dayMsgMap = new HashMap<String, Integer>();
		// 1.获取当前日期
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		String dateString = formatter.format(date);
		// 2.切割字符串
		String[]dayMsg = dateString.split("-");
		
		int yearInt = Integer.parseInt(dayMsg[0]);
		int monthInt = Integer.parseInt(dayMsg[1]);
		dayMsgMap.put("year", yearInt);
		dayMsgMap.put("month", monthInt);
		// 3.确定当月一号是星期几
		SimpleDateFormat formatWeek = new SimpleDateFormat("EEEE");
		String weekStr = formatWeek.format(formatter.parse(dayMsg[0] + "-" + dayMsg[1] + "-" + "01"));
		int weekInt = 0;
		switch (weekStr) {
		case "星期一":
			weekInt = 1;
			break;
		case "星期二":
			weekInt = 2;
			break;
		case "星期三":
			weekInt = 3;
			break;
		case "星期四":
			weekInt = 4;
			break;
		case "星期五":
			weekInt = 5;
			break;
		case "星期六":
			weekInt = 6;
			break;
		default:
			weekInt = 7;
			break;
		}
		dayMsgMap.put("week",weekInt);
		//判断本月一共有几天，先判断是否为闰年
		int monthDayHas = 0;
		if(2 == monthInt) {
			if(yearInt % 4 == 0 && yearInt % 100 != 0 || yearInt % 400 == 0) {
				//是闰年
				monthDayHas = 29;
			}else {
				monthDayHas = 28;
			}
		}else if(2 == monthInt || 4 == monthInt || 6 == monthInt || 9 == monthInt || 11 == monthInt) {
			monthDayHas = 30;
		}else {
			monthDayHas = 31;
		}
		
		dayMsgMap.put("monthDayHas", monthDayHas);
		return dayMsgMap;
	}
	
	
}
