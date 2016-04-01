package com.scm.service;

import com.scm.po.ShopInfo;
import com.scm.po.UserShopRelation;

public interface UserShopRelationService {

	int insert(UserShopRelation userShopRelation);
	
	ShopInfo selectShopInfoByUserId(Integer userId);
	
}
