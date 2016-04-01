package com.scm.controller.dic;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.SysDicInfo;
import com.scm.service.SysDicInfoService;
import com.scm.service.SysDicTypeInfoService;

@Controller
@RequestMapping("/dic")
public class SysDicInfoController extends BaseController {
	private Logger log = Logger.getLogger(SysDicInfoController.class);
	@Autowired
	public SysDicInfoService sysDicInfoService;
	@Autowired
	public SysDicTypeInfoService sysDicTypeInfoService;

	/**
	 * 跳转到树首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "index.htm")
	public String getDicInfo() {
		return "dicInfo/dic_Info";
	}

	/**
	 * 获取树数据
	 * 
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "getTreeData.do")
	@ResponseBody
	public String getTreeData(Integer pid)
			throws UnsupportedEncodingException {
		String treeData = sysDicTypeInfoService.selectSysDicTypeByPid(pid);
		return treeData;

	}

	@RequestMapping(value = "getDicInfoList.do")
	@ResponseBody
	public String getDicInfoList(String typeCode) {
		String json = "";
		if (!"".equals(typeCode)) {
			List<SysDicInfo> list = sysDicInfoService
					.selectSysDicInfoByTypeCode(typeCode,getCurrentShopInfo().getId());
			return listJson(list);
		}
		return json;
	}

	/**
	 * 新增字典值
	 * 
	 * @param dicInfo
	 * @return
	 */
	@RequestMapping(value = "saveDicInfo.do")
	@ResponseBody
	public String saveDicInfo(SysDicInfo dicInfo) {
		try {
			dicInfo.setShopId(getCurrentShopInfo().getId());
			dicInfo.setState(SecurityConstant.State.ok.getIndex());
			sysDicInfoService.insert(dicInfo);
		} catch (Exception e) {
			return errorJson("新增失败,请稍后再试或联系管理员.");
		}
		return successJson();
	}

	/**
	 * 修改字典值
	 * 
	 * @param dicInfo
	 * @return
	 */
	@RequestMapping(value = "editDicInfo.do")
	@ResponseBody
	public String editDicInfo(SysDicInfo dicInfo) {
		try {
			sysDicInfoService.updateByPrimaryKeySelective(dicInfo);
		} catch (Exception e) {
			return errorJson("编辑失败,请稍后再试或联系管理员.");
		}
	
		return successJson();

	}

	/**
	 * 删除字典值-逻辑删
	 * 
	 * @param dicInfo
	 * @return
	 */
	@RequestMapping(value = "delDicInfo.do")
	@ResponseBody
	public String delDicInfo(Integer id) {
		try {
			sysDicInfoService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return errorJson("服务器开小差了,请稍后再试!");
		}
		return successJson();
	}
}
