package com.scm.vo;

import com.scm.po.ShopInfo;
import com.scm.po.UserInfo;

public class RegisterVO {

	private UserInfo userInfo;
	
	private ShopInfo shopInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ShopInfo getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	
}
