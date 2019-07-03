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
public class Two_jurisdiction implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private Integer id;

    private String href;

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

    public String getHref() {
        return href;
    }

    public void setThref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Two_jurisdiction{" +
                "t_title='" + title + '\'' +
                ", id=" + id +
                ", thref='" + href + '\'' +
                '}';
    }
}
