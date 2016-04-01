package com.scm.controller.supplier;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopSupplierInfo;
import com.scm.po.SysDicInfo;
import com.scm.po.SysRegion;
import com.scm.service.ShopSupplierInfoService;
import com.scm.service.SysDicInfoService;
import com.scm.service.SysRegionService;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends BaseController {
	private Logger log = Logger.getLogger(SupplierController.class);
	@Autowired
	private ShopSupplierInfoService shopSupplierInfoService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private SysRegionService sysRegionService;

	@RequestMapping(value = "getSupplierList.htm")
	public String getSupplierList(ModelMap model) {
		List<SysDicInfo> levelList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.START_LEVEL,
						getCurrentShopInfo().getId());
		List<SysDicInfo> supplierTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("levelList", levelList);
		model.addAttribute("supplierTypeList", supplierTypeList);
		return "supplier/supplier_list";
	}

	@RequestMapping(value = "getSupplierListData.do")
	public String getSupplierListData(ModelMap model,
			ShopSupplierInfo shopSupplierInfo) {
		shopSupplierInfo.setShopId(getCurrentShopInfo().getId());
		PageHelper.startPage(shopSupplierInfo.getOffset(),
				shopSupplierInfo.getLimit());
		List<ShopSupplierInfo> list = shopSupplierInfoService
				.selectSupplierList(shopSupplierInfo);
		PageInfo page = new PageInfo(list);
		model.addAttribute("page", page);
		return "supplier/supplier_list_data";
	}

	@RequestMapping(value = "toAddSupplierInfo.htm")
	public String toAddSupplierInfo(ModelMap model) {
		List<SysDicInfo> supplierTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("supplierTypeList", supplierTypeList);
		List<SysRegion> allProvince = sysRegionService.getAllProvince();
		model.addAttribute("allProvince", allProvince);
		List<SysDicInfo> levelList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.START_LEVEL,
						getCurrentShopInfo().getId());
		model.addAttribute("levelList", levelList);
		return "supplier/supplier_info";
	}

	@RequestMapping(value = "toUpdateSupplierInfo.htm")
	public String toUpdateSupplierInfo(ModelMap model, Integer id) {
		List<SysDicInfo> supplierTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("supplierTypeList", supplierTypeList);
		ShopSupplierInfo shopSupplierInfo = shopSupplierInfoService
				.selectSupplierInfoById(id);
		model.addAttribute("shopSupplierInfo", shopSupplierInfo);
		List<SysRegion> allProvince = sysRegionService.getAllProvince();
		model.addAttribute("allProvince", allProvince);
		List<SysRegion> allCity = sysRegionService
				.getReginByPid(shopSupplierInfo.getProvinceId());
		model.addAttribute("allCity", allCity);
		List<SysRegion> allDistrict = sysRegionService
				.getReginByPid(shopSupplierInfo.getCityId());
		model.addAttribute("allDistrict", allDistrict);
		List<SysDicInfo> levelList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.START_LEVEL,
						getCurrentShopInfo().getId());
		model.addAttribute("levelList", levelList);
		return "supplier/supplier_info";
	}

	@RequestMapping(value = "saveOrUpdateSupplierInfo.do")
	@ResponseBody
	public String saveOrUpdateSupplierInfo(ShopSupplierInfo shopSupplierInfo) {
		shopSupplierInfo.setShopId(getCurrentShopInfo().getId());
		shopSupplierInfo.setState(SecurityConstant.State.ok.getIndex());
		shopSupplierInfoService.saveOrUpdateSupplierInfo(shopSupplierInfo);
		return successJson();
	}

	/**
	 * 逻辑删
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delSupplierInfo.do")
	@ResponseBody
	public String delSupplierInfo(Integer id) {
		shopSupplierInfoService.delShopSupplierInfo(id);
		return successJson();
	}

	@RequestMapping(value = "getSelectData.do")
	@ResponseBody
	public String getSelectData(ShopSupplierInfo shopSupplierInfo) {
		shopSupplierInfo.setShopId(getCurrentShopInfo().getId());
		List<ShopSupplierInfo> list = shopSupplierInfoService
				.selectSupplierList(shopSupplierInfo);
		String returnStr = "";
		if (list != null) {
			for (ShopSupplierInfo shopSupplierInfo2 : list) {
				returnStr += ("".equals(returnStr) ? "" : ",") + "{\"id\":"
						+ shopSupplierInfo2.getId() + ",\"name\":\""
						+ shopSupplierInfo2.getName() + "\"}";
			}
		}
		return "{\"value\":[" + returnStr + "]}";

	}
}
