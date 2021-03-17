package com.liutao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liutao.bean.DayBean;
import com.liutao.dao.DiaryMapper;

@Service
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	DiaryMapper diaryMapper;
	
	@Override
	public List<DayBean> findUserDayData(int year, int month, int userId) {
		List<DayBean> dayDataList = diaryMapper.selectDay(year,month,userId);
		return dayDataList;
	}

}
