package com.liutao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liutao.bean.UserBean;
import com.liutao.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	public boolean userRegist(UserBean user) {
		int result = userMapper.userRegiste(user);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Boolean judgeMailExsit(String registeUserMail) {
		int count = userMapper.judgeMailExsit(registeUserMail);
		if(count > 0) {
			return true;
		}
		return false;
	}

}
