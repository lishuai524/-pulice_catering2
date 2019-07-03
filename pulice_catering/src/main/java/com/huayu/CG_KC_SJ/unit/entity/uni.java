package com.huayu.CG_KC_SJ.unit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class uni {

    @TableId(value = "uid", type = IdType.AUTO)
    private int uid;
    private String name;

    @Override
    public String toString() {
        return "uni{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
