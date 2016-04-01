package com.scm.dao;

import java.util.List;

import com.scm.po.UserShopRelation;

public interface UserShopRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserShopRelation record);

    int insertSelective(UserShopRelation record);

    UserShopRelation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserShopRelation record);

    int updateByPrimaryKey(UserShopRelation record);
    
    List<UserShopRelation> selectRelationByUserId(Integer userId);
}