package com.huayu.CG_KC_SJ.stocktaking_manage.sql;

import com.huayu.CG_KC_SJ.stocktaking_manage.entity.Stocktaking_manage;

public class SelectSql_ss {
    public String  select(Stocktaking_manage stocktaking_manage){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from stocktaking_manage  where 1=1");
        if(stocktaking_manage!=null) {

            if ( stocktaking_manage.getRmiid()!= null && !"".equals(stocktaking_manage.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + stocktaking_manage.getRmiid() + "%'");
            }else if (stocktaking_manage.getSid() != null && !"".equals(stocktaking_manage.getSid())) {
                stringBuffer.append(" and sid =" + stocktaking_manage.getSid());
            }

        }
    return stringBuffer.toString();
    }
}
