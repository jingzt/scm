package com.scm.service;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.ShopPurchaseDetailInfo;

public interface ShopPurchaseService {
	
	public List<ShopPurchaseDetailInfo> selectPurchaseInfoList(ShopPurchaseDetailInfo shopPurchaseDetailInfo);
	
	public void savePurchaseInfo(ShopPurchaseDetailInfo shopPurchaseDetailInfo);
	
	public void updatePurchaseInfo(ShopPurchaseDetailInfo shopPurchaseDetailInfo);
	
	public void delPurchaseInfoById(Integer id);
	
	public List<ShopPurchaseDetailInfo> selectTotalMoneyByCreateTime(Integer shopId,String startDate,String endDate);
	
	/**
	 * 获取当月采购金额
	 * @param shopId
	 * @return
	 */
	public BigDecimal selectMonthTotalPurchase(@Param("shopId")Integer shopId);

}
