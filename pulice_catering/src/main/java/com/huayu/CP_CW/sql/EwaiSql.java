package com.huayu.CP_CW.sql;

import com.huayu.CP_CW.bean.Ewai;

public class EwaiSql {
    public String select(Ewai ewai){
        StringBuffer sql=new StringBuffer("select * from ewai where 1=1");
        if(null!=ewai){
            if ( ewai.getName()!=null && !ewai.getName().equals("")){
                sql.append(" and name like '%"+ewai.getName()+"%'");
            }
            if (ewai.getTime()!=null && !ewai.getTime().equals("")){
                sql.append(" and time like '%"+ewai.getTime()+"%'");
            }

        }
        return sql.toString();

    }
}
