package com.huayu.JC_HY_DD.reserve_tables_list.sql;

import com.huayu.JC_HY_DD.reserve_tables_list.entity.Reserve_tables_list;

public class resSql {
    public String selset(Reserve_tables_list member){
        StringBuffer str = new StringBuffer();
        str.append("select * from reserve_tables_list where 1=1");
        if (member != null){
            if (member.getReserved() != null && !member.getReserved().equals("")){
                str.append(" and reserved like '%"+member.getReserved()+"%'");
            } if(member.getOrder_date() != null && !member.getOrder_date().equals("")){
                str.append(" and order_date like '%"+member.getOrder_date()+"%'");
            }
        }
        return str.toString();
    }
}
