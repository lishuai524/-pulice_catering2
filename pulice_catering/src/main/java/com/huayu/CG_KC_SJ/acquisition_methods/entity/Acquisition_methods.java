package com.huayu.CG_KC_SJ.acquisition_methods.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Acquisition_methods implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer sid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

    private String picture;

    private Integer piid;

    private String business_hours;

    private String phone;

    private String email;

    private String site;

    private String QR_code;
    private String Acquisition_Methods;
    @TableField(exist = false)
    private Stores_information stores_information;

    public Stores_information getStores_information() {
        return stores_information;
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
    }

    @Override
    public String toString() {
        return "Acquisition_methods{" +
                "sid=" + sid +
                ", id=" + id +
                ", picture='" + picture + '\'' +
                ", piid=" + piid +
                ", business_hours='" + business_hours + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", site='" + site + '\'' +
                ", QR_code='" + QR_code + '\'' +
                ", Acquisition_Methods='" + Acquisition_Methods + '\'' +
                ", stores_information=" + stores_information +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }
    public String getBusiness_hours() {
        return business_hours;
    }

    public void setBusiness_hours(String business_hours) {
        this.business_hours = business_hours;
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

    public void setSite(String site) {
        this.site = site;
    }
    public String getQR_code() {
        return QR_code;
    }

    public void setQR_code(String QR_code) {
        this.QR_code = QR_code;
    }
    public String getAcquisition_Methods() {
        return Acquisition_Methods;
    }


}
