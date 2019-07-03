package com.huayu.JC_HY_DD.stores_information.sql;

import com.huayu.JC_HY_DD.stores_information.entity.Stores_information;

public class storSql {
    public String selset(Stores_information stores_information) {
        StringBuffer str = new StringBuffer();
        str.append("select * from stores_information where 1=1");
        if (stores_information != null) {
            if (stores_information.getShop_name() != null && !stores_information.getShop_name().equals("")) {
                str.append(" and shop_name like '%" + stores_information.getShop_name() + "%'");
            }
        }
        return str.toString();
    }

}
