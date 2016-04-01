package com.scm.vo;

import java.io.Serializable;
import java.util.List;

import com.scm.po.ShopProductInfo;
import com.scm.po.ShopProductMaterialRealtion;

public class ProductVO implements Serializable {

	private ShopProductInfo product ;
	private List<ShopProductMaterialRealtion> realtionList;
	public ShopProductInfo getProduct() {
		return product;
	}
	public void setProduct(ShopProductInfo product) {
		this.product = product;
	}
	public List<ShopProductMaterialRealtion> getRealtionList() {
		return realtionList;
	}
	public void setRealtionList(List<ShopProductMaterialRealtion> realtionList) {
		this.realtionList = realtionList;
	}

	
	
}
