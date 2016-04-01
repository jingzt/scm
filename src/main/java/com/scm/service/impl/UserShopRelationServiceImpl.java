package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.UserShopRelationMapper;
import com.scm.po.ShopInfo;
import com.scm.po.UserShopRelation;
import com.scm.service.UserShopRelationService;

@Service
public class UserShopRelationServiceImpl implements UserShopRelationService{

	@Autowired
	private UserShopRelationMapper userShopRelationMapper;
	@Override
	public int insert(UserShopRelation userShopRelation) {
		return userShopRelationMapper.insert(userShopRelation);
	}
	@Override
	public ShopInfo selectShopInfoByUserId(Integer userId) {
		// TODO Auto-generated method stub
		List<UserShopRelation> relationList = userShopRelationMapper.selectRelationByUserId(userId);
		if(relationList==null || relationList.size()==0){
			return null ;
		}
		UserShopRelation relation = relationList.get(0);
		return relation.getShopInfo();
	}

}
