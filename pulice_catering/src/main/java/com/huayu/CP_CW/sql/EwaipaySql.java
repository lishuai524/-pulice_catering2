package com.huayu.CP_CW.sql;


import com.huayu.CP_CW.bean.Ewaipay;

public class EwaipaySql {
    public String select(Ewaipay ewaipay){
        StringBuffer sql=new StringBuffer("select * from ewaipay where 1=1");
        if(null!=ewaipay){
            if ( ewaipay.getName()!=null && !ewaipay.getName().equals("")){
                sql.append(" and name like '%"+ewaipay.getName()+"%'");
            }
            if (ewaipay.getTime()!=null && !ewaipay.getTime().equals("")){
                sql.append(" and time like '%"+ewaipay.getTime()+"%'");
            }

        }
        return sql.toString();

    }
}
