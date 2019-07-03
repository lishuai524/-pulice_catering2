package com.huayu.JC_HY_DD.personal_information.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Personal_information implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer piid;

    private String company;

    private String department;

    private Integer hid;

    private Integer sid;

    private String name;

    private String username;

    private String psd;

    private String email;

    private String phone;

    private String remark;

    private String user;

    private String role;

    private String last_time;

    public Integer getPiid() {
        return piid;
    }

    public void setPiid(Integer piid) {
        this.piid = piid;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPsd() {
        return psd;
    }

    public void setPsd(String psd) {
        this.psd = psd;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    @Override
    public String toString() {
        return "Personal_information{" +
        "piid=" + piid +
        ", company=" + company +
        ", department=" + department +
        ", hid=" + hid +
        ", sid=" + sid +
        ", name=" + name +
        ", username=" + username +
        ", psd=" + psd +
        ", email=" + email +
        ", phone=" + phone +
        ", remark=" + remark +
        ", user=" + user +
        ", role=" + role +
        ", last_time=" + last_time +
        "}";
    }
}
