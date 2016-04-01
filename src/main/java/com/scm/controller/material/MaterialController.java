package com.scm.controller.material;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopMaterialInfo;
import com.scm.po.SysDicInfo;
import com.scm.service.ShopMaterialInfoService;
import com.scm.service.SysDicInfoService;

@Controller
@RequestMapping("/material")
public class MaterialController extends BaseController {
	private Logger log = Logger.getLogger(MaterialController.class);

	@Autowired
	private ShopMaterialInfoService shopMaterialInfoService;
	@Autowired
	private SysDicInfoService sysDicInfoService;

	@RequestMapping(value = "getMaterialList.htm")
	public String getMaterialInfoList(ModelMap model) {
		List<SysDicInfo> materialTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("materialTypeList", materialTypeList);
		return "material/material_list";
	}

	@RequestMapping(value = "getMaterialInfoListData.do")
	public String getMaterialInfoListData(ModelMap model,
			ShopMaterialInfo shopMaterialInfo) {
		shopMaterialInfo.setShopId(getCurrentShopInfo().getId());
		PageHelper.startPage(shopMaterialInfo.getOffset(),
				shopMaterialInfo.getLimit());
		List<ShopMaterialInfo> list = shopMaterialInfoService
				.selectMaterialList(shopMaterialInfo);
		PageInfo page = new PageInfo(list);
		model.addAttribute("page", page);
		return "material/material_list_data";
	}

	@RequestMapping(value = "toAddMaterialInfo.htm")
	public String toAddMaterialInfo(ModelMap model) {
		List<SysDicInfo> materialTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("materialTypeList", materialTypeList);

		List<SysDicInfo> UnitList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MEASUREMENT_UNIT,
						getCurrentShopInfo().getId());
		model.addAttribute("unitList", UnitList);
		return "material/material_info";
	}

	@RequestMapping(value = "toUpdateMaterialInfo.htm")
	public String toUpdateMaterialInfo(ModelMap model, Integer id) {
		List<SysDicInfo> materialTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("materialTypeList", materialTypeList);

		List<SysDicInfo> UnitList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MEASUREMENT_UNIT,
						getCurrentShopInfo().getId());
		model.addAttribute("unitList", UnitList);
		ShopMaterialInfo materialInfo = shopMaterialInfoService
				.selectMaterialInfoById(id);
		model.addAttribute("materialInfo", materialInfo);
		return "material/material_info";
	}

	@RequestMapping(value = "saveOrUpdateMaterialInfo.do")
	@ResponseBody
	public String saveOrUpdateMaterialInfo(ShopMaterialInfo shopMaterialInfo) {
		shopMaterialInfo.setShopId(getCurrentShopInfo().getId());
		shopMaterialInfo.setState(SecurityConstant.State.ok.getIndex());
		shopMaterialInfoService.saveOrUpdateMaterialInfo(shopMaterialInfo);
		return successJson();
	}

	/**
	 * 逻辑删
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delMaterialInfo.do")
	@ResponseBody
	public String delMaterialInfo(Integer id) {
		shopMaterialInfoService.delMaterialInfoById(id);
		return successJson();
	}

	@RequestMapping(value = "getSelectData.do")
	@ResponseBody
	public String getSelectData(ShopMaterialInfo shopMaterialInfo) {
		shopMaterialInfo.setShopId(getCurrentShopInfo().getId());
		List<ShopMaterialInfo> list = shopMaterialInfoService
				.selectMaterialList(shopMaterialInfo);
		return "{\"value\":" + JSONObject.toJSONString(list) + "}";
	}

	@RequestMapping(value = "getSelectDataById.do")
	@ResponseBody
	public String getSelectDataById(Integer id) {
		ShopMaterialInfo materialInfo = shopMaterialInfoService
				.selectMaterialInfoById(id);
		return JSONObject.toJSONString(materialInfo);
	}
}
