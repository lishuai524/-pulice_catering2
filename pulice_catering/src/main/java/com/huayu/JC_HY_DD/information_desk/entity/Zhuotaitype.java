package com.huayu.JC_HY_DD.information_desk.entity;

import java.io.Serializable;

public class Zhuotaitype implements Serializable {

    private static final long serialVersionUID = 1L;

    private int zid;

    private String zname;

    public int getZid() {
        return zid;
    }

    public void setZid(int zid) {
        this.zid = zid;
    }

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }
}
