package com.scm.dao;

import java.util.List;

import com.scm.po.ShopSupplierInfo;

public interface ShopSupplierInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ShopSupplierInfo record);

	int insertSelective(ShopSupplierInfo record);

	ShopSupplierInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ShopSupplierInfo record);

	int updateByPrimaryKey(ShopSupplierInfo record);

	public List<ShopSupplierInfo> selectSupplierList(ShopSupplierInfo shopSupplierInfo);
}