package com.scm.dao;

import com.scm.po.SysShopMenuRealtion;

public interface SysShopMenuRealtionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysShopMenuRealtion record);

    int insertSelective(SysShopMenuRealtion record);

    SysShopMenuRealtion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysShopMenuRealtion record);

    int updateByPrimaryKey(SysShopMenuRealtion record);
    
}