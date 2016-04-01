package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.UserLoginInfo;

public interface UserLoginInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserLoginInfo record);

    int insertSelective(UserLoginInfo record);

    UserLoginInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserLoginInfo record);

    int updateByPrimaryKey(UserLoginInfo record);
    
    List<UserLoginInfo> selectLogInfoByUserIdAndShopId(@Param("userId")Integer userId,@Param("shopId")Integer shopId);
}