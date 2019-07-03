package com.huayu.JC_HY_DD.dayinji.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Dayinji implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String yontu;

    private String ip;

    private String duanko;

    private String dayin;

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
    public String getYontu() {
        return yontu;
    }

    public void setYontu(String yontu) {
        this.yontu = yontu;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getDuanko() {
        return duanko;
    }

    public void setDuanko(String duanko) {
        this.duanko = duanko;
    }
    public String getDayin() {
        return dayin;
    }

    public void setDayin(String dayin) {
        this.dayin = dayin;
    }

    @Override
    public String toString() {
        return "Dayinji{" +
        "name=" + name +
        ", yontu=" + yontu +
        ", ip=" + ip +
        ", duanko=" + duanko +
        ", dayin=" + dayin +
        "}";
    }
}
