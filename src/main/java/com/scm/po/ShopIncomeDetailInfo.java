package com.scm.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopIncomeDetailInfo extends BaseBean implements Serializable {
	private Integer id;

	private Integer shopId;

	private Integer productId;

	private Integer consumptionStyleId;

	private BigDecimal unitPrice;

	private Integer totalNum;

	private BigDecimal totalPrice;

	private String mark;

	private Integer state;

	private Date createTime;
	
	/***********************************/
	private ShopProductInfo product ;
	
	private SysDicInfo unitType;
	
	private SysDicInfo consumptionStyle ;
	
	private String month ; //日期
	
	private BigDecimal totalMoney;  //净利润

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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getConsumptionStyleId() {
		return consumptionStyleId;
	}

	public void setConsumptionStyleId(Integer consumptionStyleId) {
		this.consumptionStyleId = consumptionStyleId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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

	public ShopProductInfo getProduct() {
		return product;
	}

	public void setProduct(ShopProductInfo product) {
		this.product = product;
	}

	public SysDicInfo getUnitType() {
		return unitType;
	}

	public void setUnitType(SysDicInfo unitType) {
		this.unitType = unitType;
	}

	public SysDicInfo getConsumptionStyle() {
		return consumptionStyle;
	}

	public void setConsumptionStyle(SysDicInfo consumptionStyle) {
		this.consumptionStyle = consumptionStyle;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}