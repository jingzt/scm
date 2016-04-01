package com.scm.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scm.constant.SecurityConstant;
import com.scm.dao.ShopProductInfoMapper;
import com.scm.dao.ShopProductMaterialRealtionMapper;
import com.scm.po.ShopProductInfo;
import com.scm.po.ShopProductMaterialRealtion;
import com.scm.service.ShopProductService;
import com.scm.vo.ProductVO;

@Service
public class ShopProductServiceImpl implements ShopProductService {
	@Autowired
	private ShopProductInfoMapper productInfoMapper;
	@Autowired
	private ShopProductMaterialRealtionMapper productMaterialRealtionMapper;

	@Override
	public ProductVO selectProductVOById(Integer id) {
		// TODO Auto-generated method stub
		ProductVO productVO = new ProductVO();
		ShopProductInfo productInfo = productInfoMapper.selectByPrimaryKey(id);
		List<ShopProductMaterialRealtion> list = productMaterialRealtionMapper
				.selectRealtionByProductId(id);
		productVO.setProduct(productInfo);
		productVO.setRealtionList(list);
		return productVO;
	}

	@Override
	public List<ShopProductInfo> selectProductList(ShopProductInfo productInfo) {
		// TODO Auto-generated method stub
		return productInfoMapper.selectProductList(productInfo);
	}

	@Override
	@Transactional
	public void saveOrUpdateProductInfo(ProductVO productVO) {
		// TODO Auto-generated method stub
		ShopProductInfo product = productVO.getProduct();
		if (product.getId() == null) {
			productInfoMapper.insert(product);
		} else {
			productInfoMapper.updateByPrimaryKeySelective(product);
		}
		List<ShopProductMaterialRealtion> realtionList = productVO.getRealtionList();
		List<ShopProductMaterialRealtion> list = productMaterialRealtionMapper.selectRealtionByProductId(product.getId());
		if (realtionList != null) {
			for (ShopProductMaterialRealtion shopProductMaterialRealtion : realtionList) {
				if (shopProductMaterialRealtion.getId() == null) {
					shopProductMaterialRealtion.setProductId(product.getId());
					productMaterialRealtionMapper
							.insert(shopProductMaterialRealtion);
				} else {
					productMaterialRealtionMapper
							.updateByPrimaryKeySelective(shopProductMaterialRealtion);
					Iterator<ShopProductMaterialRealtion> iterator = list.iterator();
					while(iterator.hasNext()){
						if(shopProductMaterialRealtion.getId().equals(iterator.next().getId())){
							iterator.remove();
						}
					}
				}
			}
		}
		if(list!=null){
			for (ShopProductMaterialRealtion shopProductMaterialRealtion : list) {
				productMaterialRealtionMapper.deleteByPrimaryKey(shopProductMaterialRealtion.getId());
			}
		}
		
		 
		productInfoMapper.updateBudgetCostAndCostByProductId(product.getId());

	}

	@Override
	public void delProductInfo(Integer id) {
		// TODO Auto-generated method stub
		ShopProductInfo shopProductInfo = new ShopProductInfo();
		shopProductInfo.setId(id);
		shopProductInfo.setState(SecurityConstant.State.del.getIndex());
		productInfoMapper.updateByPrimaryKeySelective(shopProductInfo);
	}

	@Override
	public void updateProductInfo(ShopProductInfo shopProductInfo) {
		// TODO Auto-generated method stub
		productInfoMapper.updateByPrimaryKeySelective(shopProductInfo);
	}

	@Override
	public ShopProductInfo selectProductInfoById(Integer id) {
		// TODO Auto-generated method stub
		return productInfoMapper.selectByPrimaryKey(id);
	}

	


}
