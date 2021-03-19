package com.liutao.bean;

import java.sql.Timestamp;

public class DayBean {
	
	private int dayId;
	private int year;
	private int week;
	private int month;
	private String dayText;
	private String dayImage;
	private int dayNo;
	private String festival;
	private int userId;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public DayBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public DayBean(int year, int week,int month, int dayNo,String festival, int userId) {
		super();
		this.year = year;
		this.week = week;
		this.month = month;
		this.dayNo = dayNo;
		this.festival = festival;
		this.userId = userId;
	}



	public int getDayId() {
		return dayId;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
	

	public int getMonth() {
		return month;
	}



	public void setMonth(int month) {
		this.month = month;
	}



	public String getDayText() {
		return dayText;
	}

	public void setDayText(String dayText) {
		this.dayText = dayText;
	}

	public String getDayImage() {
		return dayImage;
	}

	public void setDayImage(String dayImage) {
		this.dayImage = dayImage;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	
	public String getFestival() {
		return festival;
	}



	public void setFestival(String festival) {
		this.festival = festival;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}



	@Override
	public String toString() {
		return "DayBean [dayId=" + dayId + ", year=" + year + ", week=" + week + ", month=" + month + ", dayText="
				+ dayText + ", dayImage=" + dayImage + ", dayNo=" + dayNo + ", festival=" + festival + ", userId="
				+ userId + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

}
