package com.huayu.JC_HY_DD.member_management.sql;

import com.huayu.JC_HY_DD.member_management.entity.Member_management;

public class vipsql {
    public String selset(Member_management member){
        StringBuffer str = new StringBuffer();
        str.append("select * from member_management where 1=1");
        if (member != null){
            if (member.getName() != null && !member.getName().equals("")){
                str.append(" and name like '%"+member.getName()+"%'");
            } if(member.getNumber() != null && !member.getNumber().equals("")){
                str.append(" and number like '%"+member.getNumber()+"%'");
            }
        }
        return str.toString();
    }
}
