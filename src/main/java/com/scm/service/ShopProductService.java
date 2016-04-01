package com.scm.service;

import java.util.List;

import com.scm.po.ShopProductInfo;
import com.scm.vo.ProductVO;

public interface ShopProductService {
	public ShopProductInfo selectProductInfoById(Integer id);

	public ProductVO selectProductVOById(Integer id);
	
	public List<ShopProductInfo> selectProductList(ShopProductInfo shopProductInfo);
	
	public void saveOrUpdateProductInfo(ProductVO productVO);
	
	public void  delProductInfo(Integer id);
	
	public void updateProductInfo(ShopProductInfo shopProductInfo);
	
}
