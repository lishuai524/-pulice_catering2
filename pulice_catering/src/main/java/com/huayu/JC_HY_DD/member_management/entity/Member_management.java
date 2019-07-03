package com.huayu.JC_HY_DD.member_management.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Member_management implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String head_portrait;

    private String name;

    private String sex;

    private String birthday;

    private String number;

    private String site;

    private Double balance;

    private String cla;

    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Member_management{" +
        "head_portrait=" + head_portrait +
        ", name=" + name +
        ", sex=" + sex +
        ", birthday=" + birthday +
        ", number=" + number +
        ", site=" + site +
        ", balance=" + balance +
        ", class=" + cla +
        ", remark=" + remark +
        "}";
    }
}
