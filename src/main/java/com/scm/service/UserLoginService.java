package com.scm.service;

import java.util.List;

import com.scm.po.UserLoginInfo;

public interface UserLoginService {
	void insertLoginInfo(UserLoginInfo userLoginInfo);
	
	List<UserLoginInfo> selectLogInfoByUserIdAndShopId(Integer userId,Integer shopId);
}
