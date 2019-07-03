package com.huayu.CG_KC_SJ.procurement_plan.sql;

import com.huayu.CG_KC_SJ.procurement_plan.entity.Procurement_plan;

public class SelectSql_pr {
    public String  select(Procurement_plan procurement_plan){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from procurement_plan where 1=1");
        if(procurement_plan!=null) {

            if ( procurement_plan.getRmiid() != null && !"".equals(procurement_plan.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + procurement_plan.getRmiid() + "%'");
            }
        }
    return stringBuffer.toString();
    }
}
