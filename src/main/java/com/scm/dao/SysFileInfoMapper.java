package com.scm.dao;

import com.scm.po.SysFileInfo;

public interface SysFileInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFileInfo record);

    int insertSelective(SysFileInfo record);

    SysFileInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFileInfo record);

    int updateByPrimaryKey(SysFileInfo record);
}