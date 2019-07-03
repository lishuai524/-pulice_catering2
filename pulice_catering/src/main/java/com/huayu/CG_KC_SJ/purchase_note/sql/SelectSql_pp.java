package com.huayu.CG_KC_SJ.purchase_note.sql;

import com.huayu.CG_KC_SJ.purchase_note.entity.Purchase_note;

public class SelectSql_pp {
    public String  select(Purchase_note purchase_note){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from purchase_note where 1=1 order by id desc");
        if(purchase_note!=null) {

            if ( purchase_note.getRmiid()!= null && !"".equals(purchase_note.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + purchase_note.getRmiid() + "%'");
            }

        }
    return stringBuffer.toString();
    }
}
