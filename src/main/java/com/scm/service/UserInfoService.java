package com.scm.service;

import com.scm.po.ShopInfo;
import com.scm.po.UserInfo;

public interface UserInfoService {

	UserInfo selectByLoginName(String loginName);
	
	void addUserAndShop(UserInfo userInfo,ShopInfo shopInfo);
	
	void updateUserInfo(UserInfo userInfo);
}
