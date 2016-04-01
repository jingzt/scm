package com.scm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.ShopInfoMapper;
import com.scm.dao.UserInfoMapper;
import com.scm.po.ShopInfo;
import com.scm.po.UserInfo;
import com.scm.po.UserShopRelation;
import com.scm.service.UserInfoService;
import com.scm.service.UserShopRelationService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private ShopInfoMapper shopInfoMapper;
	@Autowired
	private UserShopRelationService userShopRelationService;

	public UserInfo selectByLoginName(String loginName) {
		return userInfoMapper.selectByLoginName(loginName);
	}

	@Transactional
	public void addUserAndShop(UserInfo userInfo, ShopInfo shopInfo) {
		userInfoMapper.insert(userInfo);
		shopInfoMapper.insert(shopInfo);
		userShopRelationService.insert(new UserShopRelation(shopInfo.getId(),userInfo.getId()));
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

}
