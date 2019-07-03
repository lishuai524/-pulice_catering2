package com.huayu.CG_KC_SJ.purchase_audit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
@TableName("purchase_audit")
public class Purchase_audit implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  serial_number;

    @Override
    public String toString() {
        return "Purchase_audit{" +
                "serial_number=" + serial_number +
                ", id=" + id +
                ", time='" + time + '\'' +
                ", rmiid='" + rmiid + '\'' +
                ", kid=" + kid +
                ", model='" + model + '\'' +
                ", quantity=" + quantity +
                ", uid=" + uid +
                ", total_prices=" + total_prices +
                ", way='" + way + '\'' +
                ", remark='" + remark + '\'' +
                ", kin=" + kin +
                ", uni=" + uni +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    private String time;

    private String  rmiid;

    private Integer kid;

    private String model;

    private Double quantity;

    private Integer uid;

    private Double total_prices;

    private String way;

    private String remark;
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

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String  getRmiid() {
        return rmiid;
    }

    public void setRmiid(String  rmiid) {
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
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Double getTotal_prices() {
        return total_prices;
    }

    public void setTotal_prices(Double total_prices) {
        this.total_prices = total_prices;
    }
    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
