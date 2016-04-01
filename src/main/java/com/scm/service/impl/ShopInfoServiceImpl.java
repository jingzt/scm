package com.scm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.ShopInfoMapper;
import com.scm.po.ShopInfo;
import com.scm.service.ShopInfoService;

@Service
public class ShopInfoServiceImpl implements ShopInfoService {

	@Autowired
	private ShopInfoMapper shopInfoMapper;

	@Override
	public void updateShopInfo(ShopInfo shopInfo) {
		// TODO Auto-generated method stub
		shopInfoMapper.updateByPrimaryKeySelective(shopInfo);
		
	}

	@Override
	public ShopInfo selectShopInfoById(Integer id) {
		// TODO Auto-generated method stub
		return shopInfoMapper.selectByPrimaryKey(id);
	}

}
