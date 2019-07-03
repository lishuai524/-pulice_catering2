package com.huayu.JC_HY_DD.take_out.sql;

import com.huayu.JC_HY_DD.take_out.entity.Take_out;

public class takeSql {
    public String selset(Take_out takeOut){
        StringBuffer str = new StringBuffer();
        str.append("select * from take_out where 1=1");
        if (takeOut != null){
            if (takeOut.getOrder_reference() != null && !takeOut.getOrder_reference().equals("")){
                str.append(" and order_reference like '%"+takeOut.getOrder_reference()+"%'");
            } if(takeOut.getCell_phone_number() != null && !takeOut.getCell_phone_number().equals("")){
                str.append(" and cell_phone_number like '%"+takeOut.getCell_phone_number()+"%'");
            }
        }
        return str.toString();
    }
}
