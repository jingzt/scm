package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.SysPrivateMenuInfoMapper;
import com.scm.po.SysPrivateMenuInfo;
import com.scm.service.SysPrivateMenuService;

@Service
public class SysPrivateMenuServiceImpl implements SysPrivateMenuService {
	@Autowired
	private SysPrivateMenuInfoMapper sysPrivateMenuInfoMapper;

	@Override
	public List<SysPrivateMenuInfo> selectAllPrivateMenuInfoList(Integer shopId) {
		// TODO Auto-generated method stub
		//查找一级菜单
		List<SysPrivateMenuInfo> menuInfoList= sysPrivateMenuInfoMapper.selectPrivateMenuInfoListByPid(shopId, 0);
		if(menuInfoList!=null){
			for (SysPrivateMenuInfo sysPrivateMenuInfo : menuInfoList) {
				List<SysPrivateMenuInfo> list = sysPrivateMenuInfoMapper.selectPrivateMenuInfoListByPid(shopId, sysPrivateMenuInfo.getId());
				sysPrivateMenuInfo.setChildMenuList(list);
			}
		}
		return menuInfoList;
	}


}
