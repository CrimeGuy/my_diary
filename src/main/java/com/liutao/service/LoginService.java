package com.liutao.service;

import com.liutao.bean.UserBean;

public interface LoginService {
	public UserBean findUserByUserName(String userName,String userPwd);
}
