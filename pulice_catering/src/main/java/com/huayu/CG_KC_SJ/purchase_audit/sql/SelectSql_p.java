package com.huayu.CG_KC_SJ.purchase_audit.sql;

import com.huayu.CG_KC_SJ.purchase_audit.entity.Purchase_audit;

public class SelectSql_p {
    public String  select(Purchase_audit purchase_audit){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from purchase_audit where 1=1 order by id desc");
        if(purchase_audit!=null) {

            if ( purchase_audit.getRmiid()!= null && !"".equals(purchase_audit.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + purchase_audit.getRmiid() + "%'");
            }

        }
    return stringBuffer.toString();
    }
}
