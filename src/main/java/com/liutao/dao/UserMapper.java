package com.liutao.dao;

import org.apache.ibatis.annotations.Param;

import com.liutao.bean.UserBean;

public interface UserMapper {
	public int userRegiste(@Param("user") UserBean user);
}
