package com.scm.dao;

import java.util.List;

import com.scm.po.SysDicTypeInfo;

public interface SysDicTypeInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysDicTypeInfo record);

	int insertSelective(SysDicTypeInfo record);

	SysDicTypeInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysDicTypeInfo record);

	int updateByPrimaryKey(SysDicTypeInfo record);

	List<SysDicTypeInfo> selectDicTypeByPid(Integer pid);
}