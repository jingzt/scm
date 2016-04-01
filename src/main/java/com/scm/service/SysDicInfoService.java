package com.scm.service;

import java.util.List;

import com.scm.po.SysDicInfo;

public interface SysDicInfoService {

	int deleteByPrimaryKey(Integer id);

	int insert(SysDicInfo record);

	SysDicInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysDicInfo record);

	/**
	 * 根据字典类型Typecode查找字典值
	 * 
	 * @param typeCode
	 *
	 * @return
	 */
	List<SysDicInfo> selectSysDicInfoByTypeCode(String code,Integer shopId);

}
