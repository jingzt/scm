package com.scm.controller.income;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopIncomeDetailInfo;
import com.scm.po.ShopInfo;
import com.scm.po.ShopProductInfo;
import com.scm.po.SysDicInfo;
import com.scm.service.ShopIncomeService;
import com.scm.service.ShopProductService;
import com.scm.service.ShopPurchaseService;
import com.scm.service.SysDicInfoService;
import com.scm.utils.DateUtils;
import com.scm.vo.IncomeVO;

@Controller
@RequestMapping("/income")
public class IncomeController extends BaseController {
	private Logger log = Logger.getLogger(IncomeController.class);
	@Autowired
	private ShopIncomeService incomeService;
	@Autowired
	private ShopPurchaseService purchaseService;
	@Autowired
	private SysDicInfoService sysDicInfoService;
	@Autowired
	private ShopProductService productService;

	@RequestMapping(value = "toIncomeCalendar.htm")
	public String toIncomeCalendar() {
		return "income/income_calendar";
	}

	@RequestMapping(value = "getIncomeCalendarData.do")
	public String getIncomeCalendarData(long start, long end, Model model) {
		List<ShopIncomeDetailInfo> list = incomeService
				.selectTotalMoneyByCreateTime(getCurrentShopInfo().getId(),
						DateUtils.getTimeByUnix(start),
						DateUtils.getTimeByUnix(end));
		model.addAttribute("incomeList", list);
		return "income/income_calendar_data";
	}

	@RequestMapping(value = "getIncomeList.htm")
	public String getIncomeList(Model model, String dateTime) {
		List<SysDicInfo> UnitList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.MEASUREMENT_UNIT,
						getCurrentShopInfo().getId());
		model.addAttribute("unitList", UnitList);

		List<SysDicInfo> consumptionStyleList = sysDicInfoService
				.selectSysDicInfoByTypeCode(SecurityConstant.CONSUMPTION_STYLE,
						getCurrentShopInfo().getId());
		model.addAttribute("consumptionStyleList", consumptionStyleList);

		ShopProductInfo shopProductInfo = new ShopProductInfo();
		shopProductInfo.setShopId(getCurrentShopInfo().getId());
		shopProductInfo.setState(SecurityConstant.State.ok.getIndex());
		List<ShopProductInfo> productList = productService
				.selectProductList(shopProductInfo);
		model.addAttribute("productList", productList);
		model.addAttribute("dateTime", dateTime);
		List<ShopIncomeDetailInfo> incomeInfoList = incomeService
				.selectIncomeInfoList(getCurrentShopInfo().getId(), dateTime);
		model.addAttribute("incomeInfoList", incomeInfoList);

		return "income/income_list";
	}

	@RequestMapping(value = "saveOrUpdateIncomeList.do")
	@ResponseBody
	public String saveOrUpdateIncomeList(String date, IncomeVO incomeVO) {
		incomeService.saveOrUpdateIncomeInfo(getCurrentShopInfo().getId(),
				date, incomeVO);
		return successJson();
	}
	
	
	@RequestMapping(value = "toGeneral.htm")
	public String toGeneral(Model model){
		ShopInfo shopInfo = getCurrentShopInfo();
		BigDecimal todayTotalInCome = incomeService.selectTodayTotalInCome(shopInfo.getId());//当天销售额
		BigDecimal monthTotalInCome = incomeService.selectMonthTotalInCome(shopInfo.getId());//当月销售额
		BigDecimal monthTotalPurchase = purchaseService.selectMonthTotalPurchase(shopInfo.getId());//当月采购额
		model.addAttribute("todayTotalInCome", todayTotalInCome);
		model.addAttribute("monthTotalInCome", monthTotalInCome);
		model.addAttribute("monthTotalPurchase", monthTotalPurchase);
		return "income/general_info";
	}
	
	@RequestMapping(value = "getBestSellersData.do")
	@ResponseBody
	public String getBestSellersData(){
		Map<String, Object> map = incomeService.getBestSellersDataForEcharts(getCurrentShopInfo().getId());
		return mapJson(map);
	}
	
	@RequestMapping(value = "getConsumptionStyleData.do")
	@ResponseBody
	public String getConsumptionStyleData(){
		Map<String, Object> map = incomeService.getConsumptionStyleDataForEcharts(getCurrentShopInfo().getId());

		return mapJson(map);
	}
	
	@RequestMapping(value = "getNearYearTotalData.do")
	@ResponseBody
	public String getNearYearTotalData(){
		Map<String, Object> map = incomeService.getNearYearTotalDataForEcharts(getCurrentShopInfo().getId());
		return mapJson(map);
	}
}
