package com.huayu.CG_KC_SJ.temporary_inventory.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Temporary_inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.kind.entity.kin kin;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.unit.entity.uni uni;

    public com.huayu.CG_KC_SJ.kind.entity.kin getKin() {

        return kin;
    }
    @TableField(exist = false)
    private Stores_information stores_information;

    public Stores_information getStores_information() {
        return stores_information;
    }

    @Override
    public String toString() {
        return "Temporary_inventory{" +
                "kin=" + kin +
                ", uni=" + uni +
                ", stores_information=" + stores_information +
                ", sid=" + sid +
                ", rmiid=" + rmiid +
                ", kid=" + kid +
                ", model='" + model + '\'' +
                ", unit_price=" + unit_price +
                ", uid=" + uid +
                ", quantity=" + quantity +
                '}';
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
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

    private Integer sid;

    private Integer rmiid;

    private Integer kid;

    private String model;

    private Double unit_price;

    private Integer uid;

    private Double quantity;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public Integer getRmiid() {
        return rmiid;
    }

    public void setRmiid(Integer rmiid) {
        this.rmiid = rmiid;
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
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

}
