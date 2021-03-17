package com.liutao.service;

import java.util.List;

import com.liutao.bean.DayBean;

public interface DiaryService {

	List<DayBean> findUserDayData(int year, int month, int userId);
	
}
