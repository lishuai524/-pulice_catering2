package com.huayu.JC_HY_DD.queue_state.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Queue_state implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "qsid", type = IdType.AUTO)
    private Integer qsid;

    private String name;

    public Integer getQsid() {
        return qsid;
    }

    public void setQsid(Integer qsid) {
        this.qsid = qsid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Queue_state{" +
        "qsid=" + qsid +
        ", name=" + name +
        "}";
    }
}
