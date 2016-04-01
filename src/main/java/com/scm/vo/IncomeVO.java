package com.scm.vo;

import java.io.Serializable;
import java.util.List;

import com.scm.po.ShopIncomeDetailInfo;

public class IncomeVO implements Serializable {

	private List<ShopIncomeDetailInfo> incomeList;

	public List<ShopIncomeDetailInfo> getIncomeList() {
		return incomeList;
	}

	public void setIncomeList(List<ShopIncomeDetailInfo> incomeList) {
		this.incomeList = incomeList;
	}
}
