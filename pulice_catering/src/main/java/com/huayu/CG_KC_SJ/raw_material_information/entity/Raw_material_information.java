package com.huayu.CG_KC_SJ.raw_material_information.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.huayu.CG_KC_SJ.kind.entity.kin;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */

@TableName("raw_material_information")
public class Raw_material_information implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rmiid", type = IdType.AUTO)
    private Integer rmiid;

    private String name;

    private String picture;

    private Integer kid;

    private String model;

    private Double unit_price;

    private Integer uid;

    private String remark;

    public kin getKin() {
        return kin;
    }

    public void setKin(kin kin) {
        this.kin = kin;
    }

    @TableField(exist = false)
    private kin kin;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.unit.entity.uni uni;

    public com.huayu.CG_KC_SJ.unit.entity.uni getUni() {
        return uni;
    }

    public void setUni(com.huayu.CG_KC_SJ.unit.entity.uni uni) {
        this.uni = uni;
    }

    public Integer getRmiid() {
        return rmiid;
    }

    public void setRmiid(Integer rmiid) {
        this.rmiid = rmiid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Raw_material_information{" +
        "rmiid=" + rmiid +
        ", name=" + name +
        ", picture=" + picture +
        ", kid=" + kid +
        ", model=" + model +
        ", unit_price=" + unit_price +
        ", uid=" + uid +
        ", remark=" + remark +
        "}";
    }

}
