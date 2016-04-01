package com.scm.service;

import java.util.List;

import com.scm.po.ShopSupplierInfo;

public interface ShopSupplierInfoService {
	public ShopSupplierInfo selectSupplierInfoById(Integer id);
	
	public List<ShopSupplierInfo>  selectSupplierList(ShopSupplierInfo shopSupplierInfo);

	public ShopSupplierInfo saveOrUpdateSupplierInfo(ShopSupplierInfo shopSupplierInfo);

	public void delShopSupplierInfo(Integer id);
}
