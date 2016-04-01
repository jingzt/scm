package com.scm.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scm.dao.ShopPurchaseDetailInfoMapper;
import com.scm.po.ShopPurchaseDetailInfo;
import com.scm.service.ShopPurchaseService;
@Service
public class ShopPurchaseServiceImpl implements ShopPurchaseService {
	@Autowired
	private ShopPurchaseDetailInfoMapper shopPurchaseDetailInfoMapper;

	@Override
	public List<ShopPurchaseDetailInfo> selectPurchaseInfoList(ShopPurchaseDetailInfo shopPurchaseDetailInfo) {
		// TODO Auto-generated method stub
		return shopPurchaseDetailInfoMapper.selectPurchaseInfoList(shopPurchaseDetailInfo);
	}

	@Override
	public void savePurchaseInfo(ShopPurchaseDetailInfo shopPurchaseDetailInfo) {
		// TODO Auto-generated method stub
		shopPurchaseDetailInfoMapper.insert(shopPurchaseDetailInfo);
	}

	@Override
	@Transactional
	public void updatePurchaseInfo(ShopPurchaseDetailInfo shopPurchaseDetailInfo) {
		// TODO Auto-generated method stub
		shopPurchaseDetailInfoMapper.updateByPrimaryKeySelective(shopPurchaseDetailInfo);
		shopPurchaseDetailInfoMapper.updateTotalMoney(shopPurchaseDetailInfo.getId());
		
	}

	@Override
	public void delPurchaseInfoById(Integer id) {
		// TODO Auto-generated method stub
		shopPurchaseDetailInfoMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 根据创建时间查询总金额,目前用于日历金额的展示
	 */
	@Override
	public List<ShopPurchaseDetailInfo> selectTotalMoneyByCreateTime(Integer shopId,String startDate,String endDate) {
		// TODO Auto-generated method stub
		return shopPurchaseDetailInfoMapper.selectTotalMoneyByCreateTime(shopId,startDate,endDate);
	}

	@Override
	public BigDecimal selectMonthTotalPurchase(Integer shopId) {
		// TODO Auto-generated method stub
		return shopPurchaseDetailInfoMapper.selectMonthTotalPurchase(shopId).getTotalMoney();
	}

}
