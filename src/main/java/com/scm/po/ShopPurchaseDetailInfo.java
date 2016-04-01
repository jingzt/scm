package com.scm.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopPurchaseDetailInfo extends BaseBean implements Serializable {
	private Integer id;

	private Integer shopId;

	private Integer materialId;

	private BigDecimal unitPrice;

	private Integer unitId;

	private BigDecimal totalNum;

	private BigDecimal totalMoney;

	private String mark;

	private Integer state;

	private Date createTime;

	/*-------------self data-----------*/
	private SysDicInfo unitType;

	private ShopMaterialInfo material;

	private Integer materialTypeId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitId() {
		return unitId;
	}

	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}

	public BigDecimal getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(BigDecimal totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark == null ? null : mark.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysDicInfo getUnitType() {
		return unitType;
	}

	public void setUnitType(SysDicInfo unitType) {
		this.unitType = unitType;
	}

	public ShopMaterialInfo getMaterial() {
		return material;
	}

	public void setMaterial(ShopMaterialInfo material) {
		this.material = material;
	}

	public Integer getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(Integer materialTypeId) {
		this.materialTypeId = materialTypeId;
	}


}