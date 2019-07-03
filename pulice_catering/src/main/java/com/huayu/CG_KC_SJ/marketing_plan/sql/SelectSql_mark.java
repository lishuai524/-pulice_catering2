package com.huayu.CG_KC_SJ.marketing_plan.sql;

import com.huayu.CG_KC_SJ.marketing_plan.entity.Marketing_plan;

public class SelectSql_mark {
    public String  select(Marketing_plan marketing_plan){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from marketing_plan where 1=1");
        if(marketing_plan!=null) {
            if (marketing_plan.getTime_frame() != null && !"".equals(marketing_plan.getTime_frame())) {
                stringBuffer.append(" and time_frame like '%" + marketing_plan.getTime_frame() + "%'");
            }else if (marketing_plan.getShop() != null && !"".equals(marketing_plan.getShop())) {
                stringBuffer.append(" and shop =" + marketing_plan.getShop());
            }
        }
    return stringBuffer.toString();
    }
}
