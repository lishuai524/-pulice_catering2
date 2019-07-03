package com.huayu.XT.role.entity;

import java.io.Serializable;
import java.util.List;

public class TChildren implements Serializable {
    private String title;
    private Integer id;
    private List<Two_jurisdiction> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Two_jurisdiction> getChildren() {
        return children;
    }

    public void setChildren(List<Two_jurisdiction> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TChildren{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }
}
