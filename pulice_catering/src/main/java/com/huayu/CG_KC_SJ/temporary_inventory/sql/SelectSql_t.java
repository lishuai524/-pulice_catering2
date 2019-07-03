package com.huayu.CG_KC_SJ.temporary_inventory.sql;

import com.huayu.CG_KC_SJ.temporary_inventory.entity.Temporary_inventory;

public class SelectSql_t {
    public String  select(Temporary_inventory temporary_inventory){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from temporary_inventory where 1=1");
        if(temporary_inventory!=null) {

            if ( temporary_inventory.getRmiid()!= null && !"".equals(temporary_inventory.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + temporary_inventory.getRmiid() + "%'");
            }else if (temporary_inventory.getSid() != null && !"".equals(temporary_inventory.getSid())) {
                stringBuffer.append(" and sid =" + temporary_inventory.getSid());
            }

        }
    return stringBuffer.toString();
    }
}
