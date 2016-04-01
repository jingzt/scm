package com.scm.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scm.constant.SecurityConstant;
import com.scm.controller.BaseController;
import com.scm.po.ShopMaterialInfo;
import com.scm.po.ShopProductInfo;
import com.scm.service.ShopMaterialInfoService;
import com.scm.service.ShopProductService;
import com.scm.service.SysDicInfoService;
import com.scm.vo.ProductVO;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	private Logger log = Logger.getLogger(ProductController.class);
	@Autowired
	private ShopProductService productService;
	@Autowired
	private ShopMaterialInfoService shopMaterialInfoService ;
	@Autowired
	private SysDicInfoService sysDicInfoService;

	@RequestMapping(value = "getProductList.htm")
	public String getProductList( ModelMap model) {
		
		return "product/product_list";
	}

	@RequestMapping(value = "getProductListData.do")
	public String getProductListData(ModelMap model,ShopProductInfo shopProductInfo) {
		PageHelper.startPage(shopProductInfo.getOffset(), shopProductInfo.getLimit());
		shopProductInfo.setShopId(getCurrentShopInfo().getId());
		List<ShopProductInfo> list = productService.selectProductList(shopProductInfo);
		PageInfo<ShopProductInfo> page= new PageInfo<ShopProductInfo>(list);
		model.addAttribute("page", page);
		return "product/product_list_data";
	}
	
	@RequestMapping(value = "toAddProductInfo.htm")
	public String toAddProductInfo(ModelMap model) {
		ShopMaterialInfo shopMaterialInfo=new ShopMaterialInfo();
		shopMaterialInfo.setShopId(getCurrentShopInfo().getId());
		List<ShopMaterialInfo> materialList = shopMaterialInfoService.selectMaterialList(shopMaterialInfo);
		model.addAttribute("materialList", materialList);
		return "product/product_info";
	}
	
	@RequestMapping(value = "toEditProductInfo.htm")
	public String toEditProductInfo(ModelMap model, Integer id) {
		ProductVO productVO = productService.selectProductVOById(id);
		model.addAttribute("productVO", productVO);
		ShopMaterialInfo shopMaterialInfo=new ShopMaterialInfo();
		shopMaterialInfo.setShopId(getCurrentShopInfo().getId());
		List<ShopMaterialInfo> materialList = shopMaterialInfoService.selectMaterialList(shopMaterialInfo);
		model.addAttribute("materialList", materialList);
		return "product/product_info";
	}
	
	@RequestMapping(value = "saveOrUpdateProductInfo.do")
	@ResponseBody
	public String saveOrUpdateProductInfo(ProductVO productVO) {
		productVO.getProduct().setShopId(getCurrentShopInfo().getId());
		productVO.getProduct().setState(SecurityConstant.State.ok.getIndex());
		productService.saveOrUpdateProductInfo(productVO);
		return successJson();
	}
	
	@RequestMapping(value = "updateProductInfo.do")
	@ResponseBody
	public String updateProductInfo(ShopProductInfo shopProductInfo){
		productService.updateProductInfo(shopProductInfo);
		return successJson();
	}
	/**
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delProductInfo.do")
	@ResponseBody
	public String delProductInfo(Integer id) {
		productService.delProductInfo(id);
		return successJson();
	}
	
	/**
	 * 根据产品ID返回产品信息JSON
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "getProductDataById.do")
	@ResponseBody
	public String getProductDataById(Integer id) {
		ShopProductInfo productInfo = productService.selectProductInfoById(id);
		return JSONObject.toJSONString(productInfo);
	}

}
