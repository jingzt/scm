package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.ShopIncomeDetailInfo;

public interface ShopIncomeDetailInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopIncomeDetailInfo record);

    int insertSelective(ShopIncomeDetailInfo record);

    ShopIncomeDetailInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopIncomeDetailInfo record);

    int updateByPrimaryKey(ShopIncomeDetailInfo record);
    
    List<ShopIncomeDetailInfo> selectIncomeInfoList(@Param("shopId")Integer shopId ,@Param("date")String date);
    
    List<ShopIncomeDetailInfo> selectTotalMoneyByCreateTime(@Param("shopId")Integer shopId ,@Param("startDate")String startDate,@Param("endDate")String endDate);
    
    ShopIncomeDetailInfo selectTodayTotalInCome(Integer shopId);
    
    ShopIncomeDetailInfo selectMonthTotalInCome(Integer shopId);
    
    List<ShopIncomeDetailInfo> selectBestSellerForDesc(Integer shopId);
    
    List<ShopIncomeDetailInfo> selectConsumptionStyleForDesc(Integer shopId);
    
    /**
     * 查找最近12个月的销售额、净利润
     * @param shopId
     * @return
     */
    List<ShopIncomeDetailInfo> selectNearYearTotalData(Integer shopId);
}