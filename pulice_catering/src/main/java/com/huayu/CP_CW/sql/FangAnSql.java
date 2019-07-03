package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.FangAn;

public class FangAnSql {
    public String select(FangAn fangAn){
        StringBuffer sql=new StringBuffer("select * from fangan where 1=1");
        if(null!=fangAn){
            if ( fangAn.getName()!=null && !fangAn.getName().equals("")){
                sql.append(" and name like '%"+fangAn.getName()+"%'");
            }

        }
        return sql.toString();

    }
}
