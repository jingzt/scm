package com.scm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.scm.po.SysPrivateMenuInfo;

public interface SysPrivateMenuInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysPrivateMenuInfo record);

	int insertSelective(SysPrivateMenuInfo record);

	SysPrivateMenuInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysPrivateMenuInfo record);

	int updateByPrimaryKey(SysPrivateMenuInfo record);

	/**
	 * 查找该店铺下菜单信息
	 * 
	 * @param shopId
	 * @param pid
	 *            传0查找顶级
	 * @return
	 */
	List<SysPrivateMenuInfo> selectPrivateMenuInfoListByPid(@Param("shopId")Integer shopId,@Param("pid")Integer pid);
}