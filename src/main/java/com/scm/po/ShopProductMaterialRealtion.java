package com.scm.po;

import java.math.BigDecimal;
import java.util.Date;

public class ShopProductMaterialRealtion {
	private Integer id;

	private Integer productId;

	private Integer materialId;

	private BigDecimal materialUnitPrice;

	private BigDecimal materialTotalNum;

	private BigDecimal materialTotalMoney;

	private Date createTime;

	private ShopMaterialInfo material;

	private ShopProductInfo product;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public BigDecimal getMaterialUnitPrice() {
		return materialUnitPrice;
	}

	public void setMaterialUnitPrice(BigDecimal materialUnitPrice) {
		this.materialUnitPrice = materialUnitPrice;
	}

	public BigDecimal getMaterialTotalNum() {
		return materialTotalNum;
	}

	public void setMaterialTotalNum(BigDecimal materialTotalNum) {
		this.materialTotalNum = materialTotalNum;
	}

	public BigDecimal getMaterialTotalMoney() {
		return materialTotalMoney;
	}

	public void setMaterialTotalMoney(BigDecimal materialTotalMoney) {
		this.materialTotalMoney = materialTotalMoney;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public ShopMaterialInfo getMaterial() {
		return material;
	}

	public void setMaterial(ShopMaterialInfo material) {
		this.material = material;
	}

	public ShopProductInfo getProduct() {
		return product;
	}

	public void setProduct(ShopProductInfo product) {
		this.product = product;
	}

}