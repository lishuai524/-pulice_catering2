package com.huayu.JC_HY_DD.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.huayu.JC_HY_DD.information_desk.entity.Capacity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Queue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "qid", type = IdType.AUTO)
    private Integer qid;

    private String type;

    private Integer capacity;

    private String remark;

    private String update_data;

    private Capacity cap;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdate_data() {
        return update_data;
    }

    public void setUpdate_data(String update_data) {
        this.update_data = update_data;
    }

    public Capacity getCap() {
        return cap;
    }

    public void setCap(Capacity cap) {
        this.cap = cap;
    }

    @Override
    public String toString() {
        return "Queue{" +
        "qid=" + qid +
        ", type=" + type +
        ", capacity=" + capacity +
        ", remark=" + remark +
        "}";
    }
}
