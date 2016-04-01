package com.scm.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;
import com.scm.constant.SecurityConstant;
import com.scm.dao.ShopIncomeDetailInfoMapper;
import com.scm.po.ShopIncomeDetailInfo;
import com.scm.service.ShopIncomeService;
import com.scm.vo.IncomeVO;

@Service
public class ShopIncomeServiceImpl implements ShopIncomeService {
	@Autowired
	private ShopIncomeDetailInfoMapper  shopIncomeDetailInfoMapper;


	@Override
	@Transactional
	public void saveOrUpdateIncomeInfo(Integer shopId,String date,IncomeVO incomeVO) {
		// TODO Auto-generated method stub
		List<ShopIncomeDetailInfo> list = selectIncomeInfoList(shopId,date);
		if(incomeVO!=null && incomeVO.getIncomeList()!=null){
			List<ShopIncomeDetailInfo> incomeList = incomeVO.getIncomeList();
			for (ShopIncomeDetailInfo shopIncomeDetailInfo : incomeList) {
				if(shopIncomeDetailInfo.getId()==null){
					shopIncomeDetailInfo.setShopId(shopId);
					shopIncomeDetailInfo.setState(SecurityConstant.State.ok.getIndex());
					shopIncomeDetailInfoMapper.insert(shopIncomeDetailInfo);
				}else{
					shopIncomeDetailInfoMapper.updateByPrimaryKeySelective(shopIncomeDetailInfo);
					Iterator<ShopIncomeDetailInfo> iterator = list.iterator();
					while(iterator.hasNext()){
						if(shopIncomeDetailInfo.getId().equals(iterator.next().getId())){
							iterator.remove();
						}
					}
				}
			}
		}
		if(list!=null){
			for (ShopIncomeDetailInfo shopIncomeDetailInfo : list) {
				shopIncomeDetailInfoMapper.deleteByPrimaryKey(shopIncomeDetailInfo.getId());
			}
		}
		
	}


	@Override
	public List<ShopIncomeDetailInfo> selectIncomeInfoList(Integer shopId, String date) {
		// TODO Auto-generated method stub
		return shopIncomeDetailInfoMapper.selectIncomeInfoList(shopId, date);
	}


	@Override
	public List<ShopIncomeDetailInfo> selectTotalMoneyByCreateTime(Integer shopId, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return shopIncomeDetailInfoMapper.selectTotalMoneyByCreateTime(shopId, startDate, endDate);
	}


	@Override
	public BigDecimal selectTodayTotalInCome(Integer shopId) {
		// TODO Auto-generated method stub
		return shopIncomeDetailInfoMapper.selectTodayTotalInCome(shopId).getTotalPrice();
	}


	@Override
	public BigDecimal selectMonthTotalInCome(Integer shopId) {
		// TODO Auto-generated method stub
		return shopIncomeDetailInfoMapper.selectMonthTotalInCome(shopId).getTotalPrice();
	}


	@Override
	public Map<String,Object> getBestSellersDataForEcharts(Integer shopId) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<String, Object>();
		List<ShopIncomeDetailInfo> list = shopIncomeDetailInfoMapper.selectBestSellerForDesc(shopId);
		List<String> nameList= new ArrayList<String>();
		List<BigDecimal> priceList=new ArrayList<BigDecimal>();
		if(list!=null){
			for (ShopIncomeDetailInfo shopIncomeDetailInfo : list) {
				nameList.add(shopIncomeDetailInfo.getProduct().getName());
				priceList.add(shopIncomeDetailInfo.getTotalPrice());
			}
		}
		map.put("category", JSONObject.toJSON(nameList));
		map.put("data",JSONObject.toJSON(priceList));
		
		return map;
	}


	@Override
	public Map<String, Object> getConsumptionStyleDataForEcharts(Integer shopId) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map= new HashMap<String, Object>();
		List<ShopIncomeDetailInfo> list = shopIncomeDetailInfoMapper.selectConsumptionStyleForDesc(shopId);
		List<String> nameList= new ArrayList<String>();
		List<EchartsForPie> pieList= new ArrayList<EchartsForPie>();
		if(list!=null){
			for (ShopIncomeDetailInfo shopIncomeDetailInfo : list) {
				nameList.add(shopIncomeDetailInfo.getConsumptionStyle().getName());
				pieList.add(new EchartsForPie(shopIncomeDetailInfo.getConsumptionStyle().getName(),shopIncomeDetailInfo.getTotalPrice()));
			}
		}
		map.put("vertical", JSONObject.toJSON(nameList));
		map.put("data",JSONObject.toJSON(pieList));
		return map;
	}

	/**
	 * 圆饼图形 name   value
	 * @author Administrator
	 *
	 */
	class EchartsForPie{
		private String name ;
		private BigDecimal value;
		
		public EchartsForPie(String name, BigDecimal value) {
			this.name = name;
			this.value = value;
		}
		public EchartsForPie() {
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public BigDecimal getValue() {
			return value;
		}
		public void setValue(BigDecimal value) {
			this.value = value;
		}
		
	}

	@Override
	public Map<String, Object> getNearYearTotalDataForEcharts(Integer shopId) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<String, Object>();
		List<ShopIncomeDetailInfo> list = shopIncomeDetailInfoMapper.selectNearYearTotalData(shopId);
		List<String> nameList = new ArrayList<String>();
		List<BigDecimal> salesList= new ArrayList<BigDecimal>();
		List<BigDecimal> realsList= new ArrayList<BigDecimal>();
		if(list!=null){
			for (ShopIncomeDetailInfo shopIncomeDetailInfo : list) {
				nameList.add(shopIncomeDetailInfo.getMonth());
				salesList.add(shopIncomeDetailInfo.getTotalPrice());
				realsList.add(shopIncomeDetailInfo.getTotalMoney());
			}
		}
		map.put("category", JSONObject.toJSON(nameList));
		map.put("sales", JSONObject.toJSON(salesList));
		map.put("reals", JSONObject.toJSON(realsList));
		return map;
	}
}
