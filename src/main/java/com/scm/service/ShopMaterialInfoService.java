package com.scm.service;

import java.util.List;

import com.scm.po.ShopMaterialInfo;

public interface ShopMaterialInfoService {
	public ShopMaterialInfo saveOrUpdateMaterialInfo(ShopMaterialInfo shopMaterialInfo);
	
	public ShopMaterialInfo selectMaterialInfoById(Integer id);
	
	public void delMaterialInfoById(Integer id);
	
	/**
	 * 查找该店铺材料列表
	 * @param shopMaterialInfo
	 * @return
	 */
	public List<ShopMaterialInfo> selectMaterialList(ShopMaterialInfo shopMaterialInfo);
	
}
