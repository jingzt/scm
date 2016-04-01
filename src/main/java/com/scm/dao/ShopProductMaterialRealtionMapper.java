package com.scm.dao;

import java.util.List;

import com.scm.po.ShopProductMaterialRealtion;

public interface ShopProductMaterialRealtionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopProductMaterialRealtion record);

    int insertSelective(ShopProductMaterialRealtion record);

    ShopProductMaterialRealtion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopProductMaterialRealtion record);

    int updateByPrimaryKey(ShopProductMaterialRealtion record);
    
    List<ShopProductMaterialRealtion> selectRealtionByProductId(Integer id);
    
}