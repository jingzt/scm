package com.scm.po;

import java.io.Serializable;
import java.util.Date;

public class ShopInfo extends BaseBean implements Serializable{
	private Integer id;

	private String name;

	private String legalPersonName;

	private String businessLicensePath;

	private String logoPath;

	private Integer categoryId;

	private Integer typeId;

	private Integer provinceId;

	private String provinceName;

	private Integer cityId;

	private String cityName;

	private Integer districtId;

	private String districtName;

	private String address;

	private String contactInformation;

	private String email;

	private String introduction;

	private String features;

	private String progressCode;

	private String progressDesc;

	private Date passTime;

	private Integer state;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName == null ? null : legalPersonName.trim();
	}

	public String getBusinessLicensePath() {
		return businessLicensePath;
	}

	public void setBusinessLicensePath(String businessLicensePath) {
		this.businessLicensePath = businessLicensePath == null ? null : businessLicensePath.trim();
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath == null ? null : logoPath.trim();
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName == null ? null : provinceName.trim();
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName == null ? null : districtName.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation == null ? null : contactInformation.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction == null ? null : introduction.trim();
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features == null ? null : features.trim();
	}

	public String getProgressCode() {
		return progressCode;
	}

	public void setProgressCode(String progressCode) {
		this.progressCode = progressCode == null ? null : progressCode.trim();
	}

	public String getProgressDesc() {
		return progressDesc;
	}

	public void setProgressDesc(String progressDesc) {
		this.progressDesc = progressDesc == null ? null : progressDesc.trim();
	}

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
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
}