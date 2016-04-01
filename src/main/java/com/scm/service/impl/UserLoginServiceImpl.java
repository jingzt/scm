package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.UserLoginInfoMapper;
import com.scm.po.UserLoginInfo;
import com.scm.service.UserLoginService;
@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired
	private UserLoginInfoMapper userLoginInfoMapper;
	@Override
	public void insertLoginInfo(UserLoginInfo userLoginInfo) {
		// TODO Auto-generated method stub
		userLoginInfoMapper.insert(userLoginInfo);
	}
	@Override
	public List<UserLoginInfo> selectLogInfoByUserIdAndShopId(Integer userId,
			Integer shopId) {
		// TODO Auto-generated method stub
		return userLoginInfoMapper.selectLogInfoByUserIdAndShopId(userId, shopId);
	}

}
