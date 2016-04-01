package com.scm.dao;

import com.scm.po.ShopInfo;

public interface ShopInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopInfo record);

    int insertSelective(ShopInfo record);

    ShopInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopInfo record);

    int updateByPrimaryKey(ShopInfo record);
}