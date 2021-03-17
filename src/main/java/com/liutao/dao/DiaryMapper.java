package com.liutao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liutao.bean.DayBean;

public interface DiaryMapper {

	List<DayBean> selectDay(@Param("year") int year, @Param("month") int month, @Param("userId") int userId);
}
