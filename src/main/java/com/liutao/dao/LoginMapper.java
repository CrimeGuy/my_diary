package com.liutao.dao;

import org.apache.ibatis.annotations.Param;

import com.liutao.bean.UserBean;

public interface LoginMapper {
	
	public UserBean findUserByUserName(@Param("userName") String userName,@Param("userPwd") String userPwd);
}
