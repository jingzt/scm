package com.scm.po;

import java.io.Serializable;
import java.util.Date;

public class SysDicTypeInfo extends BaseBean implements Serializable {
	private Integer id;

	private String name;

	private Integer pid;

	private String typeCode;

	private Integer modifyState;

	private Integer sort;

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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode == null ? null : typeCode.trim();
	}

	public Integer getModifyState() {
		return modifyState;
	}

	public void setModifyState(Integer modifyState) {
		this.modifyState = modifyState;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}