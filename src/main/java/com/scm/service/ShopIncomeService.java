package com.scm.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.scm.po.ShopIncomeDetailInfo;
import com.scm.vo.IncomeVO;

public interface ShopIncomeService {

	/**
	 * 获取该店铺当天销售详情列表
	 * 
	 * @param shopId
	 * @param date
	 * @return
	 */
	public List<ShopIncomeDetailInfo> selectIncomeInfoList(Integer shopId, String date);

	public void saveOrUpdateIncomeInfo(Integer shopId, String date, IncomeVO incomeVO);

	/**
	 * 计算一段时间内店铺销售总金额，按天展示
	 * 
	 * @param shopId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<ShopIncomeDetailInfo> selectTotalMoneyByCreateTime(Integer shopId, String startDate, String endDate);

	/**
	 * 获取当天销售金额
	 * 
	 * @param shopId
	 * @return
	 */
	public BigDecimal selectTodayTotalInCome(Integer shopId);

	/**
	 * 获取当月销售金额
	 * 
	 * @param shopId
	 * @return
	 */
	public BigDecimal selectMonthTotalInCome(Integer shopId);
	
	/**
	 * 获取当月畅销商品信息-图表专用
	 * @param shopId
	 * @return
	 */
	public Map<String, Object> getBestSellersDataForEcharts(Integer shopId);
	
	/**
	 * 获取当月消费方式-图表专用
	 * @param shopId
	 * @return
	 */
	public Map<String, Object> getConsumptionStyleDataForEcharts(Integer shopId);
	
	/**
	 * 获取包含当月在内的之前12个月的销售额+净利润
	 * @param shopId
	 * @return
	 */
	public  Map<String, Object> getNearYearTotalDataForEcharts(Integer shopId);

}
