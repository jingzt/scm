package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scm.constant.SecurityConstant;
import com.scm.dao.ShopMaterialInfoMapper;
import com.scm.po.ShopMaterialInfo;
import com.scm.service.ShopMaterialInfoService;

@Service
public class ShopMaterialInfoServiceImpl implements ShopMaterialInfoService {

	@Autowired
	private ShopMaterialInfoMapper shopMaterialInfoMapper;

	@Override
	public ShopMaterialInfo saveOrUpdateMaterialInfo(ShopMaterialInfo shopMaterialInfo) {
		// TODO Auto-generated method stub
		if (shopMaterialInfo.getId() == null) {
			shopMaterialInfoMapper.insert(shopMaterialInfo);
		} else {
			shopMaterialInfoMapper.updateByPrimaryKeySelective(shopMaterialInfo);
		}

		return shopMaterialInfo;
	}

	@Override
	public ShopMaterialInfo selectMaterialInfoById(Integer id) {
		// TODO Auto-generated method stub
		return shopMaterialInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void delMaterialInfoById(Integer id) {
		// TODO Auto-generated method stub
		ShopMaterialInfo shopMaterialInfo = new ShopMaterialInfo();
		shopMaterialInfo.setId(id);
		shopMaterialInfo.setState(SecurityConstant.State.del.getIndex());
		shopMaterialInfoMapper.updateByPrimaryKeySelective(shopMaterialInfo);
	}

	@Override
	public List<ShopMaterialInfo> selectMaterialList(ShopMaterialInfo shopMaterialInfo) {
		// TODO Auto-generated method stub
		List<ShopMaterialInfo> list = shopMaterialInfoMapper.selectMaterialList(shopMaterialInfo);
		return list;
	}

}
