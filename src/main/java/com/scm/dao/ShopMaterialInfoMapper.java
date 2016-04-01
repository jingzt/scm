package com.scm.dao;

import java.util.List;

import com.scm.po.ShopMaterialInfo;

public interface ShopMaterialInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopMaterialInfo record);

    int insertSelective(ShopMaterialInfo record);

    ShopMaterialInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopMaterialInfo record);

    int updateByPrimaryKey(ShopMaterialInfo record);
    
    public List<ShopMaterialInfo> selectMaterialList(ShopMaterialInfo shopMaterialInfo);
}