package com.huayu.CG_KC_SJ.stocktaking_manage.entity;

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
public class Stocktaking_manage implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.kind.entity.kin kin;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.unit.entity.uni uni;
    @TableField(exist = false)
    private Stores_information stores_information;

    @Override
    public String toString() {
        return "Stocktaking_manage{" +
                "kin=" + kin +
                ", uni=" + uni +
                ", stores_information=" + stores_information +
                ", sid=" + sid +
                ", rmiid=" + rmiid +
                ", kid=" + kid +
                ", model='" + model + '\'' +
                ", uid=" + uid +
                ", Current_Inventory='" + Current_Inventory + '\'' +
                ", physical_inventory='" + physical_inventory + '\'' +
                '}';
    }

    public Stores_information getStores_information() {
        return stores_information;
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
    }

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

    private Integer sid;

    private Integer rmiid;

    private Integer kid;

    private String model;

    private Integer uid;

    private String Current_Inventory;

    private String physical_inventory;

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
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getCurrent_Inventory() {
        return Current_Inventory;
    }

    public void setCurrent_Inventory(String Current_Inventory) {
        this.Current_Inventory = Current_Inventory;
    }
    public String getPhysical_inventory() {
        return physical_inventory;
    }

    public void setPhysical_inventory(String physical_inventory) {
        this.physical_inventory = physical_inventory;
    }

}
