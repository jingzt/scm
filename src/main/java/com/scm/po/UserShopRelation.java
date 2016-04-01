package com.scm.po;

import java.io.Serializable;

public class UserShopRelation extends BaseBean implements Serializable {
	private Integer id;

	private Integer shopId;

	private Integer userId;

	private UserInfo userInfo;

	private ShopInfo shopInfo;

	public UserShopRelation() {
	}

	public UserShopRelation(Integer shopId, Integer userId) {
		super();
		this.shopId = shopId;
		this.userId = userId;
	}

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ShopInfo getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

}