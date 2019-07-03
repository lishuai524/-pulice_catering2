package com.huayu.CP_CW.bean;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "JiaoJie")
public class JiaoJie {

    private int id;
    private int money;
    private String jiaojie;
    private String jieshou;
    private String jiaojietime;
    private String test;

    @Override
    public String toString() {
        return "JiaoJie{" +
                "id=" + id +
                ", money=" + money +
                ", jiaojie='" + jiaojie + '\'' +
                ", jieshou='" + jieshou + '\'' +
                ", jiaojietime='" + jiaojietime + '\'' +
                ", test='" + test + '\'' +
                '}';
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getMoney() { return money; }
    public void setMoney(int money) { this.money = money; }
    public String getJiaojie() { return jiaojie; }
    public void setJiaojie(String jiaojie) { this.jiaojie = jiaojie; }
    public String getJieshou() { return jieshou; }
    public void setJieshou(String jieshou) { this.jieshou = jieshou; }
    public String getJiaojietime() { return jiaojietime; }
    public void setJiaojietime(String jiaojietime) { this.jiaojietime = jiaojietime; }
    public String getTest() { return test; }
    public void setTest(String test) { this.test = test; }
}
