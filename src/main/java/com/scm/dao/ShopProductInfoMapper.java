package com.scm.dao;

import java.util.List;

import com.scm.po.ShopProductInfo;

public interface ShopProductInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopProductInfo record);

    int insertSelective(ShopProductInfo record);

    ShopProductInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopProductInfo record);

    int updateByPrimaryKey(ShopProductInfo record);
    
    List<ShopProductInfo> selectProductList(ShopProductInfo productInfo);
    
    /**
     * 根据材料跟产品的关联关系计算产品的预算成本和成本。成本=预算成本
     * @param id
     */
    void updateBudgetCostAndCostByProductId(Integer id);
}