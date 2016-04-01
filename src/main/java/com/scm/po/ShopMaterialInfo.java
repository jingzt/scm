package com.scm.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ShopMaterialInfo extends BaseBean implements Serializable {
    private Integer id;

    private Integer shopId;

    private String name;

    private Integer typeId;

    private Integer supplierId;

    private BigDecimal unitPrice;

    private Integer unitId;

    private String mark;

    private Integer state;
    
    private String brand;
    
    private String specifications;

    private Date createTime;
    @JSONField(serialize = false)
    private SysDicInfo materialType ;
    @JSONField(serialize = false)
    private SysDicInfo unitType ;
    @JSONField(serialize = false)
    private ShopSupplierInfo supplier ;

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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
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
    
    

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSpecifications() {
		return specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	public SysDicInfo getMaterialType() {
		return materialType;
	}

	public void setMaterialType(SysDicInfo materialType) {
		this.materialType = materialType;
	}

	public SysDicInfo getUnitType() {
		return unitType;
	}

	public void setUnitType(SysDicInfo unitType) {
		this.unitType = unitType;
	}

	public ShopSupplierInfo getSupplier() {
		return supplier;
	}

	public void setSupplier(ShopSupplierInfo supplier) {
		this.supplier = supplier;
	}
    
}