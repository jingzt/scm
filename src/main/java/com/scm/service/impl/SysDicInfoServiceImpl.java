package com.scm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.constant.SecurityConstant;
import com.scm.dao.SysDicInfoMapper;
import com.scm.po.SysDicInfo;
import com.scm.service.SysDicInfoService;

@Service
public class SysDicInfoServiceImpl implements SysDicInfoService {
	@Autowired
	private SysDicInfoMapper sysDicInfoMapper;

	@Override
	public List<SysDicInfo> selectSysDicInfoByTypeCode(String code,Integer shopId) {
		// TODO Auto-generated method stub
		return sysDicInfoMapper.selectDicInfoByTypeCode(code,shopId);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		SysDicInfo sdi= new SysDicInfo();
		sdi.setId(id);
		sdi.setState(SecurityConstant.State.del.getIndex());
		return sysDicInfoMapper.updateByPrimaryKeySelective(sdi);
	}

	@Override
	public int insert(SysDicInfo record) {
		// TODO Auto-generated method stub
		return sysDicInfoMapper.insert(record);
	}

	@Override
	public SysDicInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sysDicInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysDicInfo record) {
		// TODO Auto-generated method stub
		return sysDicInfoMapper.updateByPrimaryKeySelective(record);
	}

}
