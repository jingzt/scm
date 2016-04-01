package com.scm.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysPrivateMenuInfo extends BaseBean implements Serializable{
    private Integer id;

    private String name;

    private Integer pid;

    private String url;

    private Integer sort;

    private Integer state;

    private String styleClass;

    private Date createTime;
    
    private List<SysPrivateMenuInfo> childMenuList;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass == null ? null : styleClass.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public List<SysPrivateMenuInfo> getChildMenuList() {
		return childMenuList;
	}

	public void setChildMenuList(List<SysPrivateMenuInfo> childMenuList) {
		this.childMenuList = childMenuList;
	}
    
}