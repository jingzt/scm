package com.scm.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopProductInfo extends BaseBean  implements Serializable {
    private Integer id;

    private Integer shopId;

    private String name;

    private BigDecimal cost;

    private BigDecimal budgetCost;

    private BigDecimal price;

    private Integer state;

    private Date createTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(BigDecimal budgetCost) {
        this.budgetCost = budgetCost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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