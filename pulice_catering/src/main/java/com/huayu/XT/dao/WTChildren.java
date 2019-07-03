package com.huayu.XT.dao;

import com.huayu.XT.role.entity.TChildren;

import java.io.Serializable;
import java.util.List;

public class WTChildren implements Serializable {
    private String title;
    private Integer id;
    private List<TChildren> children;

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

    public List<TChildren> getChildren() {
        return children;
    }

    public void setChildren(List<TChildren> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "WTChildren{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", children=" + children +
                '}';
    }
}
