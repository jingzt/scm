package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.ShopPurchaseDetailInfo;

public interface ShopPurchaseDetailInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopPurchaseDetailInfo record);

    int insertSelective(ShopPurchaseDetailInfo record);

    ShopPurchaseDetailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopPurchaseDetailInfo record);

    int updateByPrimaryKey(ShopPurchaseDetailInfo record);
    
    void updateTotalMoney(Integer id);
    
    List<ShopPurchaseDetailInfo> selectPurchaseInfoList(ShopPurchaseDetailInfo shopPurchaseDetailInfo);
    
    List<ShopPurchaseDetailInfo> selectTotalMoneyByCreateTime(@Param("shopId")Integer shopId,@Param("startDate")String startDate,@Param("endDate")String endDate);
    
    ShopPurchaseDetailInfo selectMonthTotalPurchase(@Param("shopId")Integer shopId);
}