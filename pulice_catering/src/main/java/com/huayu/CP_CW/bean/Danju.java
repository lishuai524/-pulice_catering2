package com.huayu.CP_CW.bean;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "danju")
public class Danju {

    private int id;
    private String bianhao;
    private int money;
    private int type;
    private DanjuType ty;
    private String test;

    @Override
    public String toString() {
        return "Danju{" +
                "id=" + id +
                ", bianhao='" + bianhao + '\'' +
                ", money=" + money +
                ", ty=" + ty.getType() +
                ", test='" + test + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public DanjuType getTy() {
        return ty;
    }

    public void setTy(DanjuType ty) {
        this.ty = ty;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
