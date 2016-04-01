package com.scm.po;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ShopSupplierInfo extends BaseBean implements Serializable {
	private Integer id;

	private Integer shopId;

	private String name;

	private Integer typeId;

	private String contactInformation;

	private Integer provinceId;

	private String provinceName;

	private Integer cityId;

	private String cityName;

	private Integer districtId;

	private String districtName;

	private String address;

	private String addressNet;

	private Integer levelId;

	private Integer state;

	private Date createTime;

	private SysDicInfo supplierType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JSONField(serialize = false)
	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	@JSONField(serialize = false)
	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	@JSONField(serialize = false)
	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation == null ? null
				: contactInformation.trim();
	}

	@JSONField(serialize = false)
	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@JSONField(serialize = false)
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	@JSONField(serialize = false)
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@JSONField(serialize = false)
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	@JSONField(serialize = false)
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	@JSONField(serialize = false)
	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName == null ? null : districtName.trim();
	}

	@JSONField(serialize = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	@JSONField(serialize = false)
	public String getAddressNet() {
		return addressNet;
	}

	public void setAddressNet(String addressNet) {
		this.addressNet = addressNet == null ? null : addressNet.trim();
	}

	@JSONField(serialize = false)
	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	@JSONField(serialize = false)
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@JSONField(serialize = false)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JSONField(serialize = false)
	public SysDicInfo getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(SysDicInfo supplierType) {
		this.supplierType = supplierType;
	}

}