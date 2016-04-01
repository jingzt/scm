package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.dao.SysDicTypeInfoMapper;
import com.scm.po.SysDicTypeInfo;
import com.scm.service.SysDicTypeInfoService;

@Service
public class SysDicTypeInfoServiceImpl implements SysDicTypeInfoService {
	@Autowired
	private SysDicTypeInfoMapper sysDicTypeInfoMapper;

	@Override
	public String selectSysDicTypeByPid(Integer pid) {
		// TODO Auto-generated method stub
		String treeData = "[";
		List<SysDicTypeInfo> pList = sysDicTypeInfoMapper
				.selectDicTypeByPid(pid);
		for (SysDicTypeInfo dicTypeInfo : pList) {
			treeData = treeData
					+ (treeData.equals("[") ? "" : ",")
					+ ("{\"text\":\"" + dicTypeInfo.getName()
							+ "\",\"code\":\"" + dicTypeInfo.getTypeCode() + "\",\"modifyState\":\"" + dicTypeInfo.getModifyState() + "\"}");
		}
		treeData += "]";
		return treeData;
	}
}
