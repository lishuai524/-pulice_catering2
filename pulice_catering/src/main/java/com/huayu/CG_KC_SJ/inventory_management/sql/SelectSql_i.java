package com.huayu.CG_KC_SJ.inventory_management.sql;

import com.huayu.CG_KC_SJ.inventory_management.entity.Inventory_management;

public class SelectSql_i {
    public String  select(Inventory_management inventory_management){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from inventory_management  where 1=1");
        if(inventory_management!=null) {

            if ( inventory_management.getRmiid()!= null && !"".equals(inventory_management.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + inventory_management.getRmiid() + "%'");
            }else if (inventory_management.getSid() != null && !"".equals(inventory_management.getSid())) {
                stringBuffer.append(" and sid =" + inventory_management.getSid());
            }

        }
    return stringBuffer.toString();
    }
}
