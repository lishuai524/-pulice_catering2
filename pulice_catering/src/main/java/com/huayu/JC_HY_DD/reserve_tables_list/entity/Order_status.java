package com.huayu.JC_HY_DD.reserve_tables_list.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 * */
public class Order_status implements Serializable {
    private int osid;
    private String name;

    public int getOsid() {
        return osid;
    }

    public void setOsid(int osid) {
        this.osid = osid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
