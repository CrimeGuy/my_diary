package com.liutao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liutao.bean.DayBean;
import com.liutao.bean.UserBean;

public interface LoginMapper {
	
	public UserBean findUserByUserMail(@Param("userMail") String userMail,@Param("userPwd") String userPwd);

	public int insertDayBox(List<DayBean> dayBoxDataList);
}
