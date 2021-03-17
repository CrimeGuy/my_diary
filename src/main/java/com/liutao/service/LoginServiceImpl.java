package com.liutao.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liutao.bean.DayBean;
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
	@Override
	public Boolean createDayBox(List<DayBean> dayBoxDataList) {
		int isSucessInt = loginMapper.insertDayBox(dayBoxDataList);
		
		if(isSucessInt > 0) {
			return true;
		}
		return false;
	}
	@Override
	public Boolean judgeBoxExist(Map<String, Integer> dayMsgMap, int userId) {
		int countDayBox = loginMapper.countDayBox(dayMsgMap.get("year"),dayMsgMap.get("month"),userId);
		if(countDayBox > 0) {
			return true;
		}else {
			return false;
		}
	}
	
}
