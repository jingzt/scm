package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.constant.SecurityConstant;
import com.scm.dao.ShopSupplierInfoMapper;
import com.scm.po.ShopSupplierInfo;
import com.scm.service.ShopSupplierInfoService;

@Service
public class ShopSupplierInfoServiceImpl implements ShopSupplierInfoService {
	@Autowired
	private ShopSupplierInfoMapper shopSupplierInfoMapper;

	
	@Override
	public ShopSupplierInfo selectSupplierInfoById(Integer id) {
		// TODO Auto-generated method stub
		return shopSupplierInfoMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delShopSupplierInfo(Integer id) {
		// TODO Auto-generated method stub
		ShopSupplierInfo shopSupplierInfo = new ShopSupplierInfo();
		shopSupplierInfo.setId(id);
		shopSupplierInfo.setState(SecurityConstant.State.del.getIndex());
		shopSupplierInfoMapper.updateByPrimaryKeySelective(shopSupplierInfo);
	}


	@Override
	public ShopSupplierInfo saveOrUpdateSupplierInfo(ShopSupplierInfo shopSupplierInfo) {
		// TODO Auto-generated method stub
		if (shopSupplierInfo.getId() == null) {
			shopSupplierInfoMapper.insert(shopSupplierInfo);
		} else {
			shopSupplierInfoMapper.updateByPrimaryKeySelective(shopSupplierInfo);
		}
		return shopSupplierInfo;
	}
	@Override
	public List<ShopSupplierInfo> selectSupplierList(
			ShopSupplierInfo shopSupplierInfo) {
		// TODO Auto-generated method stub
		return shopSupplierInfoMapper.selectSupplierList(shopSupplierInfo);
	}

	

}
