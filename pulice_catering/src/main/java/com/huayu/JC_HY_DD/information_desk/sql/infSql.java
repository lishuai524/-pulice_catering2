package com.huayu.JC_HY_DD.information_desk.sql;

import com.huayu.JC_HY_DD.information_desk.entity.Information_desk;

public class infSql {
    public String selset(Information_desk desk){
        StringBuffer str = new StringBuffer();
        str.append("select * from information_desk where 1=1");
        if(null != desk && null != desk.getSotid() ){
            if (desk.getCapacity() != null && !desk.getCapacity().equals("")){
                str.append(" and capacity ="+desk.getCapacity());
            }if(desk.getSotid()>0){
                str.append(" and sotid="+desk.getSotid());
            }
        }
        return str.toString();
    }
}
