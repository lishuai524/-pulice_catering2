package com.huayu.CG_KC_SJ.cost_of_ingredients.sql;

import com.huayu.CG_KC_SJ.cost_of_ingredients.entity.Cost_of_ingredients;

public class SelectSql_C {
    public String  select(Cost_of_ingredients cost_of_ingredients){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from cost_of_ingredients  where 1=1");
        if(cost_of_ingredients!=null) {

            if ( cost_of_ingredients.getRmiid()!= null && !"".equals(cost_of_ingredients.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + cost_of_ingredients.getRmiid() + "%'");
            }else if (cost_of_ingredients.getSid() != null && !"".equals(cost_of_ingredients.getSid())) {
                stringBuffer.append(" and sid =" + cost_of_ingredients.getSid());
            }


        }
    return stringBuffer.toString();
    }
}
