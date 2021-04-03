package com.liutao.service;

import com.liutao.bean.UserBean;

public interface UserService {
	public boolean userRegist(UserBean user);

	public Boolean judgeMailExsit(String registeUserMail);
}
