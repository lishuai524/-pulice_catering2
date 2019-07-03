package com.huayu.CP_CW.CP.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zxx
 * @since 2019-06-12
 */
public class Caiping extends Model<Caiping> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String cname;

    private Integer caidanid;

    private String img;

    private String name;

    private Integer type;

    private String cailiao;

    private String number;

    private String danwei;

    private String maker;

    private Integer price;

    private String xiugai;

    private String tesecai;

    private String test;
    @TableField(exist = false)
    private Caipingtype caipingtype;
    @TableField(exist = false)
    private Danwei danwei1;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getCailiao() {
        return cailiao;
    }

    public void setCailiao(String cailiao) {
        this.cailiao = cailiao;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Integer getCaidanid() {

        return caidanid;
    }

    public void setCaidanid(Integer caidanid) {

        this.caidanid = caidanid;
    }

    public String getXiugai() {

        return xiugai;
    }

    public void setXiugai(String xiugai) {

        this.xiugai = xiugai;
    }

    public String getTesecai() {

        return tesecai;
    }

    public void setTesecai(String tesecai) {

        this.tesecai = tesecai;
    }

    public Caipingtype getCaipingtype() {

        return caipingtype;
    }

    public void setCaipingtype(Caipingtype caipingtype) {

        this.caipingtype = caipingtype;
    }

   public Danwei getDanwei1() {

      return danwei1;
   }

   public void setDanwei1(Danwei danwei1) {

      this.danwei1 = danwei1;
   }

    public String getCname() {

        return cname;
    }

    public void setCname(String cname) {

        this.cname = cname;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Caiping{" +
        "id=" + id +
        ", img=" + img +
        ", name=" + name +
        ", type=" + type +
        ", cailiao=" + cailiao +
        ", number=" + number +
        ", danwei=" + danwei +
        ", maker=" + maker +
        ", price=" + price +
        ", test=" + test +
        "}";
    }
}
