package com.huayu.CP_CW.bean;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "youhui")
public class Youhui {

    private int id;
    private String name;
    private int money;
    private String start;
    private String end;
    private String test;

    @Override
    public String toString() {
        return "Youhui{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", star='" + start + '\'' +
                ", end='" + end + '\'' +
                ", test='" + test + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String star) {
        this.start = star;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
