package com.huayu.JC_HY_DD.queuing_management.sql;

import com.huayu.JC_HY_DD.queuing_management.entity.Queuing_management;

public class questaSql {
    public String selset(Queuing_management queuing){
        StringBuffer str = new StringBuffer();
        str.append("select * from queuing_management where 1=1");
        if (queuing != null){
            if (queuing.getNumber() != null && !queuing.getNumber().equals("")){
                str.append(" and number like '%"+queuing.getNumber()+"%'");
            }
            if(queuing.getCapacity() != null && !queuing.getCapacity().equals("") &&!queuing.getCapacity().equals("a")){
                str.append(" and capacity ="+queuing.getCapacity());
            }
        }
        return str.toString();
    }
}
