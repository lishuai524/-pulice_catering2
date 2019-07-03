package com.huayu.CG_KC_SJ.menu_statistics.sql;

import com.huayu.CG_KC_SJ.menu_statistics.entity.Menu_statistics;

public class SelectSql {
    public String  select(Menu_statistics menu_statistics){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from menu_statistics where 1=1");
        if(menu_statistics!=null) {

            if ( menu_statistics.getMmid()!= null && !"".equals(menu_statistics.getMmid())) {
                stringBuffer.append(" and mmid like '%" + menu_statistics.getMmid()+ "%'");
            }else if (menu_statistics.getSid() != null && !"".equals(menu_statistics.getSid())) {
                stringBuffer.append(" and sid =" + menu_statistics.getSid());
            }


        }
    return stringBuffer.toString();
    }
}
