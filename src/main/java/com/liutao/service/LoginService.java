package com.liutao.service;

import java.util.List;

import com.liutao.bean.DayBean;
import com.liutao.bean.UserBean;

public interface LoginService {
	public UserBean findUserByUserMail(String userMail,String userPwd);

	public Boolean createDayBox(List<DayBean> dayBoxDataList);
}
