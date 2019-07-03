package com.huayu.JC_HY_DD.order_management.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-06-12
 */
public class Order_management implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String order_reference;

    private Integer ldid;

    private String name;

    private String cell_phone_number;

    private String greens_name;

    private Double unit_price;

    private String unit;

    private Double quantity;

    private Double prices;

    private Double discount_coupon;

    private String time;

    private Integer osid;

    private String remark;

    public String getOrder_reference() {
        return order_reference;
    }

    public void setOrder_reference(String order_reference) {
        this.order_reference = order_reference;
    }
    public Integer getLdid() {
        return ldid;
    }

    public void setLdid(Integer ldid) {
        this.ldid = ldid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCell_phone_number() {
        return cell_phone_number;
    }

    public void setCell_phone_number(String cell_phone_number) {
        this.cell_phone_number = cell_phone_number;
    }
    public String getGreens_name() {
        return greens_name;
    }

    public void setGreens_name(String greens_name) {
        this.greens_name = greens_name;
    }
    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }
    public Double getDiscount_coupon() {
        return discount_coupon;
    }

    public void setDiscount_coupon(Double discount_coupon) {
        this.discount_coupon = discount_coupon;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public Integer getOsid() {
        return osid;
    }

    public void setOsid(Integer osid) {
        this.osid = osid;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order_management{" +
        "order_reference=" + order_reference +
        ", ldid=" + ldid +
        ", name=" + name +
        ", cell_phone_number=" + cell_phone_number +
        ", greens_name=" + greens_name +
        ", unit_price=" + unit_price +
        ", unit=" + unit +
        ", quantity=" + quantity +
        ", prices=" + prices +
        ", discount_coupon=" + discount_coupon +
        ", time=" + time +
        ", osid=" + osid +
        ", remark=" + remark +
        "}";
    }
}
