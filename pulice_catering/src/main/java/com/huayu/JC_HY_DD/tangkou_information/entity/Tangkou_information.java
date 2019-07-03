package com.huayu.JC_HY_DD.tangkou_information.entity;

//import com.huayu.CP_CW.food_category.entity.Food_category;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Tangkou_information implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String category;

    private String printer;

    private String executive_chef;

    private String remarks;
//    private Food_category categorys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }
    public String getExecutive_chef() {
        return executive_chef;
    }

    public void setExecutive_chef(String executive_chef) {
        this.executive_chef = executive_chef;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

//    public Food_category getCategorys() {
//        return categorys;
//    }
//
//    public void setCategorys(Food_category categorys) {
//        this.categorys = categorys;
//    }

    @Override
    public String toString() {
        return "Tangkou_information{" +
        "name=" + name +
        ", category=" + category +
        ", printer=" + printer +
        ", executive_chef=" + executive_chef +
        ", remarks=" + remarks +
        "}";
    }
}
