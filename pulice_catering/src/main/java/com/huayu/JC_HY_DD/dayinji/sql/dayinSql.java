package com.huayu.JC_HY_DD.dayinji.sql;

import com.huayu.JC_HY_DD.dayinji.entity.Dayinji;

public class dayinSql {
    public String selset(Dayinji dayinji){
        StringBuffer str = new StringBuffer();
        str.append("select * from dayinji where 1=1");
        if (dayinji != null){
            if (dayinji.getName() != null && !dayinji.getName().equals("")){
                str.append(" and name like '%"+dayinji.getName()+"%'");
            }
        }
        return str.toString();
    }
}
