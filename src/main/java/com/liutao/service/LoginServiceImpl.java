package com.liutao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liutao.bean.UserBean;
import com.liutao.dao.LoginMapper;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired 
	LoginMapper loginMapper;
	public UserBean findUserByUserMail(String userMail,String userPwd) {
		UserBean user = loginMapper.findUserByUserMail(userMail,userPwd);
		return user;
	}

}
