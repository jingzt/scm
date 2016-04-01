package com.scm.controller.purchase;

import java.util.List;

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
import com.scm.po.ShopPurchaseDetailInfo;
import com.scm.po.SysDicInfo;
import com.scm.service.ShopPurchaseService;
import com.scm.service.SysDicInfoService;
import com.scm.utils.DateUtils;

@Controller
@RequestMapping("/purchase")
public class PurchaseController extends BaseController {
	private Logger log = Logger.getLogger(PurchaseController.class);
	@Autowired
	private ShopPurchaseService purchaseService;
	@Autowired
	private SysDicInfoService sysDicInfoService;

	@RequestMapping(value = "toPurchaseCalendar.htm")
	public String toPurchaseCalendar() {
		return "purchase/purchase_calendar";
	}

	@RequestMapping(value = "getPurchaseCalendarData.do")
	public String getPurchaseCalendarData(long start, long end, ModelMap model) {
		List<ShopPurchaseDetailInfo> list = purchaseService
				.selectTotalMoneyByCreateTime(getCurrentShopInfo().getId(),
						DateUtils.getTimeByUnix(start),
						DateUtils.getTimeByUnix(end));
		model.addAttribute("purchaseList", list);
		return "purchase/purchase_calendar_data";
	}

	@RequestMapping(value = "getPurchaseList.htm")
	public String getSupplierList(ModelMap model, String dateTime) {
		List<SysDicInfo> UnitList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MEASUREMENT_UNIT,
						getCurrentShopInfo().getId());
		model.addAttribute("unitList", UnitList);
		List<SysDicInfo> materialTypeList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MATERIAL_TYPE,
						getCurrentShopInfo().getId());
		model.addAttribute("materialTypeList", materialTypeList);
		model.addAttribute("dateTime", dateTime);
		return "purchase/purchase_list";
	}

	@RequestMapping(value = "getPurchaseListData.do")
	public String getData(ModelMap model, ShopPurchaseDetailInfo purchaseInfo) {
		purchaseInfo.setShopId(getCurrentShopInfo().getId());
		PageHelper.startPage(purchaseInfo.getOffset(), purchaseInfo.getLimit());
		List<ShopPurchaseDetailInfo> list = purchaseService
				.selectPurchaseInfoList(purchaseInfo);
		PageInfo page = new PageInfo(list);
		model.addAttribute("page", page);
		return "purchase/purchase_list_data";
	}

	@RequestMapping(value = "savePurchaseInfo.do")
	@ResponseBody
	public String savePurchaseInfo(ShopPurchaseDetailInfo purchaseInfo) {
		purchaseInfo.setShopId(getCurrentShopInfo().getId());
		purchaseInfo.setState(SecurityConstant.State.ok.getIndex());
		purchaseService.savePurchaseInfo(purchaseInfo);
		return successJson();
	}

	@RequestMapping(value = "updatePurchaseInfo.do")
	@ResponseBody
	public String updatePurchaseInfo(ShopPurchaseDetailInfo purchaseInfo) {
		purchaseService.updatePurchaseInfo(purchaseInfo);
		return successJson();
	}

	/**
	 * 物理删
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delPurchaseInfo.do")
	@ResponseBody
	public String delPurchaseInfo(Integer id) {
		purchaseService.delPurchaseInfoById(id);
		return successJson();
	}

}
