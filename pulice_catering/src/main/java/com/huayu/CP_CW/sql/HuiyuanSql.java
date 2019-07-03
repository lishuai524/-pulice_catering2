package com.huayu.CP_CW.sql;

import com.huayu.CP_CW.bean.Huiyuan;

public class HuiyuanSql {
    public String select(Huiyuan huiyuan){
        StringBuffer sql=new StringBuffer("select * from huiyuan where 1=1");
        if(null!= huiyuan){
            if ( huiyuan.getName()!=null && !huiyuan.getName().equals("")){
                sql.append(" and name like '%"+huiyuan.getName()+"%'");
            }

        }
        return sql.toString();

    }
}
