package com.liutao.service;

import com.liutao.bean.UserBean;

public interface LoginService {
	public UserBean findUserByUserMail(String userMail,String userPwd);
}
