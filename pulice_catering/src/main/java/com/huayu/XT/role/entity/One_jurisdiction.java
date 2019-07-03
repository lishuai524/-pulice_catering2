package com.huayu.XT.role.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-17
 */
public class One_jurisdiction implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String w_title;

    private Integer w_id;

    private Integer tid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getW_title() {
        return w_title;
    }

    public void setW_title(String w_title) {
        this.w_title = w_title;
    }
    public Integer getW_id() {
        return w_id;
    }

    public void setW_id(Integer w_id) {
        this.w_id = w_id;
    }
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "One_jurisdiction{" +
                "name='" + name + '\'' +
                ", w_title='" + w_title + '\'' +
                ", w_id=" + w_id +
                ", tid=" + tid +
                '}';
    }
}
