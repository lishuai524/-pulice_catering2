package com.huayu.JC_HY_DD.asset_information.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Asset_information implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String raw_material;

    private String kind;

    private String specification;

    private Double inventory;

    private Double consume;

    private String unit;

    private String suggest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaw_material() {
        return raw_material;
    }

    public void setRaw_material(String raw_material) {
        this.raw_material = raw_material;
    }
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
    public Double getInventory() {
        return inventory;
    }

    public void setInventory(Double inventory) {
        this.inventory = inventory;
    }
    public Double getConsume() {
        return consume;
    }

    public void setConsume(Double consume) {
        this.consume = consume;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "Asset_information{" +
        "raw_material=" + raw_material +
        ", kind=" + kind +
        ", specification=" + specification +
        ", inventory=" + inventory +
        ", consume=" + consume +
        ", unit=" + unit +
        ", suggest=" + suggest +
        "}";
    }
}
