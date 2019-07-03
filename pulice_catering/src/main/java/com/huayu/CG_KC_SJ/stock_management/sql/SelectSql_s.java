package com.huayu.CG_KC_SJ.stock_management.sql;

import com.huayu.CG_KC_SJ.stock_management.entity.Stock_management;

public class SelectSql_s {
    public String  select(Stock_management stock_management){
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("select * from stock_management where 1=1");
        if(stock_management!=null) {
            if ( stock_management.getRmiid()!= null && !"".equals(stock_management.getRmiid())) {
                stringBuffer.append(" and rmiid like '%" + stock_management.getRmiid() + "%'");
            }else if(stock_management.getOdd()!=null && !"".equals(stock_management.getOdd())){
                stringBuffer.append(" and odd ="+stock_management.getOdd());
            }else if(stock_management.getData()!=null && !"".equals(stock_management.getData())){
                stringBuffer.append("and data like '%" +stock_management.getData()+ "%'");
            }

    }
        return stringBuffer.toString();
}
}
