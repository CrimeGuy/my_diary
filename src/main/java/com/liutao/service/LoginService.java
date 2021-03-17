package com.liutao.service;

import java.util.List;
import java.util.Map;

import com.liutao.bean.DayBean;
import com.liutao.bean.UserBean;

public interface LoginService {
	public UserBean findUserByUserMail(String userMail,String userPwd);

	public Boolean createDayBox(List<DayBean> dayBoxDataList);

	public Boolean judgeBoxExist(Map<String, Integer> dayMsgMap, int userId);
}
