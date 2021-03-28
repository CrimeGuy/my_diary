package com.liutao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liutao.common.MailCommon;
import com.liutao.common.SimpleCalendar;

public class Test {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		String currSun = dateFm.format(date);
		System.out.println(currSun);
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date(System.currentTimeMillis());
		String dateString = formatter.format(date);
		String[]dayMsg = dateString.split("-");
		System.out.println(Integer.parseInt(dayMsg[1]));
		String weekStr = dateFm.format(formatter.parse(dayMsg[0] + "-" + dayMsg[1] + "-" + "01"));
		System.out.println(weekStr);
		date = formatter.parse("2021" + "-" + "02" + "-" + "12");
		SimpleCalendar.Element element = SimpleCalendar.getCalendarDetail(date);
		System.out.println(element);
		
		MailCommon mailSend = new MailCommon();
		mailSend.sendMail("Lt837631788@gmail.com","registe","1234");
	}
}
