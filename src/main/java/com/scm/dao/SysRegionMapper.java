package com.scm.dao;

import java.util.List;

import com.scm.po.SysRegion;

public interface SysRegionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysRegion record);

	int insertSelective(SysRegion record);

	SysRegion selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysRegion record);

	int updateByPrimaryKey(SysRegion record);

	List<SysRegion> getAllProvince();

	List<SysRegion> getReginByPid(Integer pid);
}