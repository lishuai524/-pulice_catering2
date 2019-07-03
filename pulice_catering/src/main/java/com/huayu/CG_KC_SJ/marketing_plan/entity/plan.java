package com.huayu.CG_KC_SJ.marketing_plan.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class plan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "plan{" +
                "Current_Inventory='" + Current_Inventory + '\'' +
                ", name='" + name + '\'' +
                ", kid=" + kid +
                ", unit_price=" + unit_price +
                ", kin=" + kin +
                ", uni=" + uni +
                ", uid=" + uid +
                '}';
    }

    public String getCurrent_Inventory() {
        return Current_Inventory;
    }

    public void setCurrent_Inventory(String current_Inventory) {
        Current_Inventory = current_Inventory;
    }

    private  String Current_Inventory;
   private String  name;
   private Integer  kid;
   private double  unit_price;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.kind.entity.kin kin;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.unit.entity.uni uni;

    public com.huayu.CG_KC_SJ.kind.entity.kin getKin() {
        return kin;
    }

    public void setKin(com.huayu.CG_KC_SJ.kind.entity.kin kin) {
        this.kin = kin;
    }

    public com.huayu.CG_KC_SJ.unit.entity.uni getUni() {
        return uni;
    }

    public void setUni(com.huayu.CG_KC_SJ.unit.entity.uni uni) {
        this.uni = uni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    private Integer  uid;

}
