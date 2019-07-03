package com.huayu.JC_HY_DD.asset_information.entity;

import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;

import java.io.Serializable;

public class Property implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String belong_to_shop;

    private String name;

    private int margin;

    private String unit;

    private String unit_price;

    private String supplydate;

    private String suggest;

    private String type;

    private Stores_information stores_information;

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

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSupplydate() {
        return supplydate;
    }

    public void setSupplydate(String supplydate) {
        this.supplydate = supplydate;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBelong_to_shop() {
        return belong_to_shop;
    }

    public void setBelong_to_shop(String belong_to_shop) {
        this.belong_to_shop = belong_to_shop;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(String unit_price) {
        this.unit_price = unit_price;
    }

    public Stores_information getStores_information() {
        return stores_information;
    }

    public void setStores_information(Stores_information stores_information) {
        this.stores_information = stores_information;
    }
}
