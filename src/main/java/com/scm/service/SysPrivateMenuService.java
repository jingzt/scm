package com.scm.service;

import java.util.List;

import com.scm.po.SysPrivateMenuInfo;

public interface SysPrivateMenuService {

	/**
	 * 查找该店铺私有菜单
	 * 
	 * @param shopId
	 * @return
	 */
	public List<SysPrivateMenuInfo> selectAllPrivateMenuInfoList(Integer shopId);

}
