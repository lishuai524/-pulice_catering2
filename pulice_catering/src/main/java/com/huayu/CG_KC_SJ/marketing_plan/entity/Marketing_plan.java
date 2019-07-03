package com.huayu.CG_KC_SJ.marketing_plan.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;
//import com.huayu.CP_CW.food_list.entity.Food_list;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Marketing_plan implements Serializable {

    private static final long serialVersionUID = 1L;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.kind.entity.kin kin;
    @TableField(exist = false)
    private com.huayu.CG_KC_SJ.unit.entity.uni uni;

    @Override
    public String toString() {
        return "Marketing_plan{" +
                "kin=" + kin +
                ", uni=" + uni +
//                ", food_list=" + food_list +
                ", id=" + id +
                ", time_frame='" + time_frame + '\'' +
                ", shop=" + shop +
                ", cuisine=" + cuisine +
                ", category=" + category +
                ", afternoon_session=" + afternoon_session +
                ", lateness_session=" + lateness_session +
                ", festival_afternoon_session=" + festival_afternoon_session +
                ", festival_lateness_session=" + festival_lateness_session +
                ", remark='" + remark + '\'' +
                ", stores_information=" + stores_information +
                '}';
    }

//    public Food_list getFood_list() {
//
//        return food_list;
//    }
//
//    public void setFood_list(Food_list food_list) {
//        this.food_list = food_list;
//    }
//
//    @TableField(exist = false)
//     private Food_list food_list;


    public com.huayu.CG_KC_SJ.unit.entity.uni getUni() {
        return uni;
    }

    public void setUni(com.huayu.CG_KC_SJ.unit.entity.uni uni) {
        this.uni = uni;
    }

    private int id;

    private String time_frame;


    private Integer shop;

    private Integer cuisine;

    private Integer category;

    private Double afternoon_session;

    private Double lateness_session;

    private Double festival_afternoon_session;

    private Double festival_lateness_session;

    private  String  remark ;

    @TableField(exist = false)
    private Stores_information stores_information;

    public Stores_information getStores_information() {
        return stores_information;
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
    }

    public com.huayu.CG_KC_SJ.kind.entity.kin getKin() {
        return kin;
    }

    public void setKin(com.huayu.CG_KC_SJ.kind.entity.kin kin) {
        this.kin = kin;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTime_frame() {
        return time_frame;
    }

    public void setTime_frame(String time_frame) {
        this.time_frame = time_frame;
    }
    public Integer getShop() {
        return shop;
    }

    public void setShop(Integer shop) {
        this.shop = shop;
    }
    public Integer getCuisine() {
        return cuisine;
    }

    public void setCuisine(Integer cuisine) {
        this.cuisine = cuisine;
    }
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    public Double getAfternoon_session() {
        return afternoon_session;
    }

    public void setAfternoon_session(Double afternoon_session) {
        this.afternoon_session = afternoon_session;
    }
    public Double getLateness_session() {
        return lateness_session;
    }

    public void setLateness_session(Double lateness_session) {
        this.lateness_session = lateness_session;
    }
    public Double getFestival_afternoon_session() {
        return festival_afternoon_session;
    }

    public void setFestival_afternoon_session(Double festival_afternoon_session) {
        this.festival_afternoon_session = festival_afternoon_session;
    }
    public Double getFestival_lateness_session() {
        return festival_lateness_session;
    }

    public void setFestival_lateness_session(Double festival_lateness_session) {
        this.festival_lateness_session = festival_lateness_session;
    }


}
