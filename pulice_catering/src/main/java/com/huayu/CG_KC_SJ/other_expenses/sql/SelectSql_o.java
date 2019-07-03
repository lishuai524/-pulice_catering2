package com.huayu.CG_KC_SJ.other_expenses.sql;

import com.huayu.CG_KC_SJ.other_expenses.entity.Other_expenses;

public class SelectSql_o {
    public String  select(Other_expenses other_expenses){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from other_expenses  where 1=1");
        if(other_expenses!=null) {

            if ( other_expenses.getRmiid()!= null && !"".equals(other_expenses.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + other_expenses.getRmiid() + "%'");
            }else if (other_expenses.getSid() != null && !"".equals(other_expenses.getSid())) {
                stringBuffer.append(" and sid =" + other_expenses.getSid());
            }


        }
    return stringBuffer.toString();
    }
}
