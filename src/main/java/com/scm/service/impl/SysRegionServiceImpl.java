package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.SysRegionMapper;
import com.scm.po.SysRegion;
import com.scm.service.SysRegionService;
@Service
public class SysRegionServiceImpl implements SysRegionService {
	@Autowired
	private SysRegionMapper sysRegionMapper;

	@Override
	public List<SysRegion> getAllProvince() {
		// TODO Auto-generated method stub
		return sysRegionMapper.getAllProvince();
	}

	@Override
	public List<SysRegion> getReginByPid(Integer pid) {
		// TODO Auto-generated method stub
		return sysRegionMapper.getReginByPid(pid);
	}

}
