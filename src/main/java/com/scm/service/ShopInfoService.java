package com.scm.service;

import com.scm.po.ShopInfo;

public interface ShopInfoService {
	void updateShopInfo(ShopInfo shopInfo);
	ShopInfo selectShopInfoById(Integer id);
	
}
