package com.scm.controller.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopInfo;
import com.scm.po.SysDicInfo;
import com.scm.po.SysRegion;
import com.scm.po.UserInfo;
import com.scm.po.UserLoginInfo;
import com.scm.service.ShopInfoService;
import com.scm.service.SysDicInfoService;
import com.scm.service.SysRegionService;
import com.scm.service.UserLoginService;

@Controller
@RequestMapping("/shop")
public class ShopInfoController extends BaseController {

	@Autowired
	private ShopInfoService shopInfoService;
	@Autowired
	private SysRegionService sysRegionService;
	@Autowired
	private SysDicInfoService dicInfoService;
	@Autowired
	private UserLoginService  userLoginService;

	@RequestMapping("/index.htm")
	public String index(Model model) {
		ShopInfo shop = getCurrentShopInfo();
		model.addAttribute("shop", shop);
		UserInfo user = getCurrentUserInfo();
		model.addAttribute("user", user);
		List<UserLoginInfo> userLogList = userLoginService.selectLogInfoByUserIdAndShopId(user.getId(), shop.getId());
		model.addAttribute("userLogList",userLogList);
		return "shop/user_shop_info";
	}

	@RequestMapping("/toEditShopInfo.htm")
	public String toEditShopInfo(Model model) {
		ShopInfo shopInfo = getCurrentShopInfo();
		model.addAttribute("shop", shopInfo);
		List<SysRegion> allProvince = sysRegionService.getAllProvince();
		model.addAttribute("allProvince", allProvince);
		
		List<SysRegion> allCity = sysRegionService.getReginByPid(shopInfo.getProvinceId());
		model.addAttribute("allCity", allCity);
		List<SysRegion> allDistrict = sysRegionService.getReginByPid(shopInfo.getCityId());
		model.addAttribute("allDistrict", allDistrict);
		
		List<SysDicInfo> shopTypeList = dicInfoService.selectSysDicInfoByTypeCode(SecurityConstant.SHOP_TYPE, shopInfo.getId());
		List<SysDicInfo> businessTypeList = dicInfoService.selectSysDicInfoByTypeCode(SecurityConstant.BUSINESS_TYPE, shopInfo.getId());
		model.addAttribute("shopTypeList", shopTypeList);
		model.addAttribute("businessTypeList",businessTypeList);
		return "shop/shop_info";
	}

	@RequestMapping("/saveShopInfo.do")
	@ResponseBody
	public String saveShopInfo(ShopInfo shopInfo) {
		shopInfoService.updateShopInfo(shopInfo);
		shopInfo=shopInfoService.selectShopInfoById(shopInfo.getId());
		setSessionAttribute(SecurityConstant.SCM_ERP_SHOP_COOKIE_KEY, shopInfo);
		return successJson();
	}

}
