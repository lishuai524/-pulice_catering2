package com.huayu.CG_KC_SJ.other_expenses.entity;

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
public class Other_expenses implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sid;

    private String starting_time;

    private String deadline;

    private Integer rmiid;

    private String cost;
    @TableField(exist = false)
    private Stores_information stores_information;

    @Override
    public String toString() {
        return "Other_expenses{" +
                "sid=" + sid +
                ", starting_time='" + starting_time + '\'' +
                ", deadline='" + deadline + '\'' +
                ", rmiid=" + rmiid +
                ", cost='" + cost + '\'' +
                ", stores_information=" + stores_information +
                '}';
    }

    public Stores_information getStores_information() {
        return stores_information;
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(String starting_time) {
        this.starting_time = starting_time;
    }
    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    public Integer getRmiid() {
        return rmiid;
    }

    public void setRmiid(Integer rmiid) {
        this.rmiid = rmiid;
    }
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

}
