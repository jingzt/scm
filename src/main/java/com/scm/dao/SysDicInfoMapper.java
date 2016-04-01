package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.SysDicInfo;

public interface SysDicInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysDicInfo record);

	int insertSelective(SysDicInfo record);

	SysDicInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysDicInfo record);

	int updateByPrimaryKey(SysDicInfo record);

	List<SysDicInfo> selectDicInfoByTypeCode(@Param("code") String code,
			@Param("shopId") Integer shopId);
}