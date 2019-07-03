package com.huayu.JC_HY_DD.order_management.sql;

import com.huayu.JC_HY_DD.order_management.entity.Order_management;

public class orderSql {
    public String selset(Order_management management){
        StringBuffer str = new StringBuffer();
        str.append("select * from order_management where 1=1");
        if (management != null){
            if (management.getOrder_reference() != null && !management.getOrder_reference().equals("")){
                str.append(" and order_reference like '%"+management.getOrder_reference()+"%'");
            }if(management.getCell_phone_number() != null && !management.getCell_phone_number().equals("")){
                str.append(" and cell_phone_number like '%"+management.getCell_phone_number()+"%'");
            }
        }
        return str.toString();
    }
}
