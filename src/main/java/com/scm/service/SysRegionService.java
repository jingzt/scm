package com.scm.service;

import java.util.List;

import com.scm.po.SysRegion;

public interface SysRegionService {
	public List<SysRegion> getAllProvince();
	public List<SysRegion> getReginByPid(Integer pid);
}
