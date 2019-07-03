package com.huayu.JC_HY_DD.staffs.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Staffs implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String head_portrait;

    private String job_number;

    private String name;

    private String login;

    private String psd;

    private String email;

    private String phone;

    private String mobile_phone;

    private String sex;

    private String site;

    private int qq;

    private String vx;

    private String identity_card;

    private int age;

    private String role;

    private String company;

    private String department;

    private String shop;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getVx() {
        return vx;
    }

    public void setVx(String vx) {
        this.vx = vx;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Staffs{" +
                "id=" + id +
                ", head_portrait='" + head_portrait + '\'' +
                ", job_number='" + job_number + '\'' +
                ", name=" + name +
                ", login=" + login +
                ", psd='" + psd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", sex='" + sex + '\'' +
                ", site='" + site + '\'' +
                ", qq=" + qq +
                ", vx='" + vx + '\'' +
                ", identity_card='" + identity_card + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", company='" + company + '\'' +
                ", department='" + department + '\'' +
                ", shop='" + shop + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
