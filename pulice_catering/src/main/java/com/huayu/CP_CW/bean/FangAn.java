package com.huayu.CP_CW.bean;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "fangan")
public class FangAn {

    private int id;
    private String name;
    private String test;
    private String time;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTest() { return test; }
    public void setTest(String test) { this.test = test; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
}
