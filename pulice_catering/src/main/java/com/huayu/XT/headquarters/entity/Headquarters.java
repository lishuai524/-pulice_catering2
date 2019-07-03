package com.huayu.XT.headquarters.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-25
 */
@TableName(value = "headquarters")
public class Headquarters implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;

    private String manager;

    private String name;

    private String head_portrait;

    private String start_business_hours;

    private String end_business_hours;

    private String phone;

    private String email;

    private String method;

    private String site;

    private String qr_code;

    private String administrator;

    private String date_changed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public String getStart_business_hours() {
        return start_business_hours;
    }

    public void setStart_business_hours(String start_business_hours) {
        this.start_business_hours = start_business_hours;
    }

    public String getEnd_business_hours() {
        return end_business_hours;
    }

    public void setEnd_business_hours(String end_business_hours) {
        this.end_business_hours = end_business_hours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSite() {
        return site;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setSite(String site) {
        this.site = site;
    }
    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }
    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
    public String getDate_changed() {
        return date_changed;
    }

    public void setDate_changed(String date_changed) {
        this.date_changed = date_changed;
    }

    @Override
    public String toString() {
        return "Headquarters{" +
                "manager='" + manager + '\'' +
                ", name='" + name + '\'' +
                ", head_portrait='" + head_portrait + '\'' +
                ", start_business_hours='" + start_business_hours + '\'' +
                ", end_business_hours='" + end_business_hours + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", method='" + method + '\'' +
                ", site='" + site + '\'' +
                ", qr_code='" + qr_code + '\'' +
                ", administrator='" + administrator + '\'' +
                ", date_changed='" + date_changed + '\'' +
                '}';
    }
}
