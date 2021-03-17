package com.liutao.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) throws ParseException {
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
	}
}
